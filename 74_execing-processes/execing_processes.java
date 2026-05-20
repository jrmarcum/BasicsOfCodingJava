// Java cannot replace the current process like Go's syscall.Exec;
// ProcessBuilder spawns a subprocess and waits for it to finish.

void main() throws Exception {
    var isWindows = System.getProperty("os.name").toLowerCase().contains("win");
    ProcessBuilder pb;
    if (isWindows) {
        pb = new ProcessBuilder("cmd", "/c", "dir");
    } else {
        pb = new ProcessBuilder("ls", "-a", "-l", "-h");
    }
    pb.inheritIO();
    var proc = pb.start();
    proc.waitFor();
}
