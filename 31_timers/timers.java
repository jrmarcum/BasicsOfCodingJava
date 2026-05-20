import java.util.concurrent.*;

void main() throws Exception {
    var scheduler = Executors.newScheduledThreadPool(2);

    var timer1 = scheduler.schedule(
        () -> System.out.println("Timer 1 fired"),
        2, TimeUnit.SECONDS);
    timer1.get();

    var timer2 = scheduler.schedule(
        () -> System.out.println("Timer 2 fired"),
        1, TimeUnit.SECONDS);
    boolean stopped = timer2.cancel(false);
    if (stopped) {
        System.out.println("Timer 2 stopped");
    }

    Thread.sleep(2000);
    scheduler.shutdown();
}
