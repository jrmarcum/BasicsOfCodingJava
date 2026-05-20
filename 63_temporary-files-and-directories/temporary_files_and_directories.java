import java.io.*;
import java.nio.file.*;
import java.util.Comparator;

void main() throws Exception {
    Path f = Files.createTempFile("sample", "");
    System.out.println("Temp file name: " + f);
    try {
        Files.write(f, new byte[]{1, 2, 3, 4});
    } finally {
        Files.deleteIfExists(f);
    }

    Path dname = Files.createTempDirectory("sampledir");
    System.out.println("Temp dir name: " + dname);
    try {
        Path fname = dname.resolve("file1");
        Files.write(fname, new byte[]{1, 2});
    } finally {
        Files.walk(dname)
            .sorted(Comparator.reverseOrder())
            .map(Path::toFile)
            .forEach(File::delete);
    }
}
