import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

class Container {
    private final ReentrantLock mu = new ReentrantLock();
    final Map<String, Integer> counters = new LinkedHashMap<>();

    Container() {
        counters.put("a", 0);
        counters.put("b", 0);
    }

    void inc(String name) {
        mu.lock();
        try {
            counters.merge(name, 1, Integer::sum);
        } finally {
            mu.unlock();
        }
    }
}

void main() throws Exception {
    var c = new Container();
    var latch = new CountDownLatch(3);

    Thread.ofVirtual().start(() -> { for (int i = 0; i < 10000; i++) c.inc("a"); latch.countDown(); });
    Thread.ofVirtual().start(() -> { for (int i = 0; i < 10000; i++) c.inc("a"); latch.countDown(); });
    Thread.ofVirtual().start(() -> { for (int i = 0; i < 10000; i++) c.inc("b"); latch.countDown(); });

    latch.await();
    System.out.println(c.counters);
}
