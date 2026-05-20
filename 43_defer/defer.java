import java.io.*;

FileWriter createFile(String p) throws IOException {
    System.out.println("creating");
    return new FileWriter(p);
}

void writeFile(FileWriter f) throws IOException {
    System.out.println("writing");
    f.write("data\n");
}

void closeFile(FileWriter f) throws IOException {
    System.out.println("closing");
    f.close();
}

void main() throws IOException {
    var f = createFile("./tmp/defer.txt");
    try {
        writeFile(f);
    } finally {
        closeFile(f);
    }
}
