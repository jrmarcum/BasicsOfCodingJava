// Output varies by OS and current date/time.

import java.io.*;

void main() throws Exception {
    var isWindows = System.getProperty("os.name").toLowerCase().contains("win");

    // date command
    ProcessBuilder dateCmd;
    if (isWindows) {
        dateCmd = new ProcessBuilder("cmd", "/c", "date /t");
    } else {
        dateCmd = new ProcessBuilder("date");
    }
    var dateOut = new String(dateCmd.start().getInputStream().readAllBytes()).trim();
    System.out.println("> date");
    System.out.println(dateOut);
    System.out.println();

    // date with bad flag — expect non-zero exit code
    ProcessBuilder badCmd;
    if (isWindows) {
        badCmd = new ProcessBuilder("cmd", "/c", "exit 1");
    } else {
        badCmd = new ProcessBuilder("date", "-x");
    }
    var badProc = badCmd.start();
    int rc = badProc.waitFor();
    System.out.println("command exit rc = " + rc);
    System.out.println();

    // grep hello from stdin via pipe
    ProcessBuilder grepCmd;
    if (isWindows) {
        grepCmd = new ProcessBuilder("findstr", "hello");
    } else {
        grepCmd = new ProcessBuilder("grep", "hello");
    }
    var grepProc = grepCmd.start();
    try (var grepIn = grepProc.getOutputStream()) {
        grepIn.write("hello grep\ngoodbye grep".getBytes());
    }
    var grepBytes = grepProc.getInputStream().readAllBytes();
    grepProc.waitFor();
    System.out.println("> grep hello");
    System.out.println(new String(grepBytes).trim());
    System.out.println();

    // ls / dir command
    System.out.println("> ls -a -l -h");
    ProcessBuilder lsCmd;
    if (isWindows) {
        lsCmd = new ProcessBuilder("cmd", "/c", "dir");
    } else {
        lsCmd = new ProcessBuilder("bash", "-c", "ls -a -l -h");
    }
    var lsOut = new String(lsCmd.start().getInputStream().readAllBytes());
    System.out.println(lsOut.trim());
}
