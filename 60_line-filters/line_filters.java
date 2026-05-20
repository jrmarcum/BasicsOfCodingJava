import java.io.*;

void main() {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line.toUpperCase());
        }
    } catch (IOException e) {
        System.err.println("error: " + e.getMessage());
        System.exit(1);
    }
}
