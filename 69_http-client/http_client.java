import java.net.URI;
import java.net.http.*;
import java.io.*;

void main() throws Exception {
    var client = HttpClient.newHttpClient();
    var request = HttpRequest.newBuilder()
        .uri(URI.create("https://gobyexample.com"))
        .build();
    var response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());
    System.out.println("Response status: " + response.statusCode() + " OK");
    var reader = new java.io.BufferedReader(new java.io.InputStreamReader(response.body()));
    reader.lines().limit(5).forEach(System.out::println);
}
