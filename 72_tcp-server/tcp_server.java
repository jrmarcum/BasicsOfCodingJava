import java.net.*;
import java.io.*;

void handleConnection(Socket conn) {
    try (conn) {
        var reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        var message = reader.readLine();
        if (message != null) {
            var response = "ACK: " + message.strip().toUpperCase() + "\n";
            conn.getOutputStream().write(response.getBytes());
        }
    } catch (IOException e) {
        System.err.println("Read error: " + e.getMessage());
    }
}

void main() throws Exception {
    var listener = new ServerSocket(8090);
    System.out.println("TCP server listening on :8090");
    while (true) {
        var conn = listener.accept();
        Thread.ofVirtual().start(() -> handleConnection(conn));
    }
}
