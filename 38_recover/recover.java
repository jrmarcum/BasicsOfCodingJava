void mayPanic() {
    throw new RuntimeException("a problem");
}

void main() {
    try {
        mayPanic();
        System.out.println("After mayPanic()");
    } catch (RuntimeException r) {
        System.out.println("Recovered. Error:\n " + r.getMessage());
    }
}
