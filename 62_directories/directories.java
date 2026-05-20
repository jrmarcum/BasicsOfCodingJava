import java.io.*;
import java.nio.file.*;
import java.util.Comparator;

void createEmptyFile(String name) throws IOException {
    Files.writeString(Path.of(name), "");
}

void main() throws Exception {
    Files.createDirectory(Path.of("subdir"));
    try {
        createEmptyFile("subdir/file1");

        Files.createDirectories(Path.of("subdir/parent/child"));
        createEmptyFile("subdir/parent/file2");
        createEmptyFile("subdir/parent/file3");
        createEmptyFile("subdir/parent/child/file4");

        System.out.println("Listing subdir/parent");
        try (var entries = Files.list(Path.of("subdir/parent"))) {
            entries.sorted().forEach(p -> {
                System.out.println("  " + p.getFileName() + " " + Files.isDirectory(p));
            });
        }

        System.out.println("Listing subdir/parent/child");
        try (var entries = Files.list(Path.of("subdir/parent/child"))) {
            entries.sorted().forEach(p -> {
                System.out.println("  " + p.getFileName() + " " + Files.isDirectory(p));
            });
        }

        System.out.println("Visiting subdir");
        Files.walk(Path.of("subdir")).sorted().forEach(p -> {
            System.out.println("  " + p.toString().replace('\\', '/') + " " + Files.isDirectory(p));
        });
    } finally {
        Files.walk(Path.of("subdir"))
            .sorted(Comparator.reverseOrder())
            .map(Path::toFile)
            .forEach(File::delete);
    }
}
