// Waits for Ctrl+C (SIGINT); shutdown hook prints the exit message.

void main() throws Exception {
    System.out.println("awaiting signal");
    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
        System.out.println();
        System.out.println("exiting");
    }));
    // Block the main thread indefinitely until a signal terminates the JVM.
    Thread.currentThread().join();
}
