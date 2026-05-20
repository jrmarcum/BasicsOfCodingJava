import com.sun.net.httpserver.*;
import java.net.*;

void main() throws Exception {
    var server = HttpServer.create(new InetSocketAddress(8090), 0);
    server.createContext("/hello", exchange -> {
        var response = "hello\n".getBytes();
        exchange.sendResponseHeaders(200, response.length);
        try (var out = exchange.getResponseBody()) { out.write(response); }
    });
    server.createContext("/headers", exchange -> {
        var sb = new StringBuilder();
        for (var entry : exchange.getRequestHeaders().entrySet()) {
            for (var val : entry.getValue()) {
                sb.append(entry.getKey()).append(": ").append(val).append("\n");
            }
        }
        var response = sb.toString().getBytes();
        exchange.sendResponseHeaders(200, response.length);
        try (var out = exchange.getResponseBody()) { out.write(response); }
    });
    server.start();
}
