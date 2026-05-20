import java.util.concurrent.CompletableFuture;

void main() throws Exception {
    var c1 = new CompletableFuture<String>();
    var c2 = new CompletableFuture<String>();

    var f1 = c1;
    var f2 = c2;

    CompletableFuture.runAsync(() -> {
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        f1.complete("one");
    });
    CompletableFuture.runAsync(() -> {
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
        f2.complete("two");
    });

    CompletableFuture<String> r1 = c1;
    CompletableFuture<String> r2 = c2;

    for (int i = 0; i < 2; i++) {
        String result = (String) CompletableFuture.anyOf(r1, r2).get();
        System.out.println("received " + result);
        if (result.equals("one")) {
            r1 = new CompletableFuture<>();
        } else {
            r2 = new CompletableFuture<>();
        }
    }
}
