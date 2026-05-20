import java.util.concurrent.*;

void worker(int id) throws InterruptedException {
    System.out.printf("Worker %d starting%n", id);
    Thread.sleep(1000);
    System.out.printf("Worker %d done%n", id);
}

void main() throws Exception {
    var latch = new CountDownLatch(5);

    for (int i = 1; i <= 5; i++) {
        final int id = i;
        Thread.ofVirtual().start(() -> {
            try {
                worker(id);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                latch.countDown();
            }
        });
    }

    latch.await();
}
