import java.util.concurrent.LinkedBlockingQueue;

void main() throws InterruptedException {
    var messages = new LinkedBlockingQueue<String>();

    Thread.ofVirtual().start(() -> {
        try {
            messages.put("ping");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    });

    String msg = messages.take();
    System.out.println(msg);
}
