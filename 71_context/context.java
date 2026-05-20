import com.sun.net.httpserver.*;
import java.net.*;
import java.io.*;
import java.util.concurrent.*;

void main() throws Exception {
    var server = HttpServer.create(new InetSocketAddress(8090), 0);
    server.createContext("/hello", exchange -> {
        System.out.println("server: hello handler started");
        // Use a CompletableFuture to simulate work with cancellation support.
        // orTimeout cancels the future if the client disconnects before 10 seconds.
        var future = CompletableFuture.supplyAsync(() -> {
            try { Thread.sleep(10000); } catch (InterruptedException e) { return null; }
            return "hello\n";
        }).orTimeout(10, TimeUnit.SECONDS);
        try {
            var response = future.get();
            if (response != null) {
                var bytes = response.getBytes();
                exchange.sendResponseHeaders(200, bytes.length);
                try (var out = exchange.getResponseBody()) { out.write(bytes); }
            }
        } catch (CancellationException | TimeoutException e) {
            System.out.println("server: " + e.getMessage());
            exchange.sendResponseHeaders(500, -1);
            exchange.getResponseBody().close();
        } catch (Exception e) {
            System.out.println("server: " + e.getMessage());
            exchange.sendResponseHeaders(500, -1);
            exchange.getResponseBody().close();
        }
        System.out.println("server: hello handler ended");
    });
    server.start();
    System.out.println("server: listening on :8090");
}
