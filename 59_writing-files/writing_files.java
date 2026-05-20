import java.io.*;
import java.nio.file.*;

void main() throws Exception {
    byte[] d1 = "hello\njava\n".getBytes();
    Files.write(Path.of("./tmp/dat1.txt"), d1);

    FileOutputStream f = new FileOutputStream("./tmp/dat2.txt");

    byte[] d2 = {115, 111, 109, 101, 10};
    f.write(d2);
    System.out.printf("wrote %d bytes%n", d2.length);

    byte[] d3 = "writes\n".getBytes();
    f.write(d3);
    System.out.printf("wrote %d bytes%n", d3.length);

    f.flush();

    BufferedOutputStream w = new BufferedOutputStream(f);
    byte[] d4 = "buffered\n".getBytes();
    w.write(d4);
    System.out.printf("wrote %d bytes%n", d4.length);

    w.flush();
    f.close();
}
