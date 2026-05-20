import java.util.concurrent.*;
import java.time.*;

void main() throws Exception {
    var scheduler = Executors.newScheduledThreadPool(1);

    var future = scheduler.scheduleAtFixedRate(
        () -> System.out.println("Tick at " + Instant.now()),
        0, 500, TimeUnit.MILLISECONDS);

    Thread.sleep(1600);
    future.cancel(false);
    scheduler.shutdownNow();
    System.out.println("Ticker stopped");
}
