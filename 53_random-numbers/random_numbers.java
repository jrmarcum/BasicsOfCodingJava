import java.util.Random;

void main() {
    Random rand = new Random();
    System.out.print(rand.nextInt(100) + ",");
    System.out.println(rand.nextInt(100));

    System.out.println(rand.nextDouble());

    System.out.print((rand.nextDouble() * 5) + 5 + ",");
    System.out.println((rand.nextDouble() * 5) + 5);

    Random r1 = new Random(System.nanoTime());
    System.out.print(r1.nextInt(100) + ",");
    System.out.println(r1.nextInt(100));

    Random r2 = new Random(42);
    System.out.print(r2.nextInt(100) + ",");
    System.out.println(r2.nextInt(100));

    Random r3 = new Random(42);
    System.out.print(r3.nextInt(100) + ",");
    System.out.print(r3.nextInt(100));
}
