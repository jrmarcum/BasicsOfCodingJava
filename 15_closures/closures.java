import java.util.function.IntSupplier;

IntSupplier intSeq() {
    int[] i = {0};
    return () -> ++i[0];
}

void main() {
    IntSupplier nextInt = intSeq();

    System.out.println(nextInt.getAsInt());
    System.out.println(nextInt.getAsInt());
    System.out.println(nextInt.getAsInt());

    IntSupplier newInts = intSeq();
    System.out.println(newInts.getAsInt());
}
