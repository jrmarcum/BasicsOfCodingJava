import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

void main() throws Exception {
    var ops = new AtomicLong();
    var latch = new CountDownLatch(50);

    for (int i = 0; i < 50; i++) {
        Thread.ofVirtual().start(() -> {
            for (int j = 0; j < 1000; j++) {
                ops.incrementAndGet();
            }
            latch.countDown();
        });
    }

    latch.await();
    System.out.println("ops: " + ops.get());
}
