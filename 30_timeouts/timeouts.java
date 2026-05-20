import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

void main() throws Exception {
    var c1 = CompletableFuture.supplyAsync(() -> {
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
        return "result 1";
    });
    try {
        System.out.println(c1.get(1, TimeUnit.SECONDS));
    } catch (TimeoutException e) {
        System.out.println("timeout 1");
    }

    var c2 = CompletableFuture.supplyAsync(() -> {
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
        return "result 2";
    });
    try {
        System.out.println(c2.get(3, TimeUnit.SECONDS));
    } catch (TimeoutException e) {
        System.out.println("timeout 2");
    }
}
