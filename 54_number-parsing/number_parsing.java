void main() {
    double f = Double.parseDouble("1.234");
    System.out.println(f);

    long i = Long.parseLong("123");
    System.out.println(i);

    long d = Long.decode("0x1c8");
    System.out.println(d);

    long u = Long.parseUnsignedLong("789");
    System.out.println(u);

    int k = Integer.parseInt("135");
    System.out.println(k);

    try {
        Integer.parseInt("wat");
    } catch (NumberFormatException e) {
        System.out.println(e);
    }
}
