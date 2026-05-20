import java.io.*;
import java.nio.file.*;

void main() throws Exception {
    byte[] dat = Files.readAllBytes(Path.of("./tmp/dat.txt"));
    System.out.print(new String(dat));

    RandomAccessFile f = new RandomAccessFile("./tmp/dat.txt", "r");

    byte[] b1 = new byte[5];
    int n1 = f.read(b1);
    System.out.printf("%d bytes: %s%n", n1, new String(b1, 0, n1));

    f.seek(6);
    byte[] b2 = new byte[2];
    int n2 = f.read(b2);
    System.out.printf("%d bytes @ %d: ", n2, 6L);
    System.out.printf("%s%n", new String(b2, 0, n2));

    f.seek(6);
    byte[] b3 = new byte[2];
    f.readFully(b3);
    System.out.printf("%d bytes @ %d: %s%n", b3.length, 6L, new String(b3));

    f.seek(0);

    BufferedReader r4 = new BufferedReader(new FileReader("./tmp/dat.txt"));
    char[] b4 = new char[5];
    r4.read(b4, 0, 5);
    System.out.printf("5 bytes: %s%n", new String(b4));
    r4.close();

    f.close();
}
