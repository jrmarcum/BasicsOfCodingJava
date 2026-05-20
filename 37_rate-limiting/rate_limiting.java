import java.util.concurrent.*;
import java.time.*;

void main() throws Exception {
    var requests = new LinkedBlockingQueue<Integer>();
    for (int i = 1; i <= 5; i++) requests.put(i);

    var limiter = Executors.newScheduledThreadPool(1);
    var limiterQueue = new LinkedBlockingQueue<Instant>();

    limiter.scheduleAtFixedRate(
        () -> { try { limiterQueue.put(Instant.now()); } catch (InterruptedException e) {} },
        0, 200, TimeUnit.MILLISECONDS);

    for (int req : requests.stream().toList()) {
        limiterQueue.take();
        System.out.println("request " + req + " " + Instant.now());
    }

    var burstyLimiter = new LinkedBlockingQueue<Instant>(3);
    for (int i = 0; i < 3; i++) burstyLimiter.put(Instant.now());

    limiter.scheduleAtFixedRate(
        () -> { try { if (burstyLimiter.remainingCapacity() > 0) burstyLimiter.put(Instant.now()); } catch (InterruptedException e) {} },
        200, 200, TimeUnit.MILLISECONDS);

    var burstyRequests = new LinkedBlockingQueue<Integer>();
    for (int i = 1; i <= 5; i++) burstyRequests.put(i);

    for (int req : burstyRequests.stream().toList()) {
        burstyLimiter.take();
        System.out.println("request " + req + " " + Instant.now());
    }

    limiter.shutdownNow();
}
