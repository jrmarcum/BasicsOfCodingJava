void f(String from) {
    for (int i = 0; i < 3; i++) {
        System.out.println(from + " : " + i);
    }
}

void main() throws InterruptedException {
    f("direct");

    Thread t1 = Thread.ofVirtual().start(() -> f("goroutine"));

    Thread t2 = Thread.ofVirtual().start(() -> System.out.println("going"));

    t1.join();
    t2.join();
    System.out.println("done");
}
