void main() {
    final String s = "constant";
    System.out.println(s);

    final long n = 500000000L;

    final double d = 3e20 / n;
    System.out.println(d);

    System.out.println((long) d);

    System.out.println(Math.sin(n));
}
