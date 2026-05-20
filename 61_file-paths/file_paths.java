import java.nio.file.*;

void main() {
    // Path.of() constructs paths portably (backslash on Windows, forward slash on Unix).
    var p = Path.of("dir1", "dir2", "filename");
    System.out.println("p: " + p);

    // Path.of() normalizes superfluous separators.
    System.out.println(Path.of("dir1//", "filename"));
    System.out.println(Path.of("dir1/../dir1", "filename").normalize());

    // getParent() and getFileName() split the directory and base name.
    System.out.println("Dir(p): " + p.getParent());
    System.out.println("Base(p): " + p.getFileName());

    // Check whether a path is absolute.
    System.out.println(Path.of("dir/file").isAbsolute());
    System.out.println(Path.of("/dir/file").isAbsolute());

    var filename = "config.json";

    // Extract the file extension (suffix after the last dot).
    var ext = filename.substring(filename.lastIndexOf('.'));
    System.out.println(ext);

    // Strip the extension to get the base name.
    System.out.println(filename.substring(0, filename.lastIndexOf('.')));

    // relativize() finds a relative path between two paths.
    var rel = Path.of("a/b").relativize(Path.of("a/b/t/file"));
    System.out.println(rel);

    var rel2 = Path.of("a/b").relativize(Path.of("a/c/t/file"));
    System.out.println(rel2);
}
