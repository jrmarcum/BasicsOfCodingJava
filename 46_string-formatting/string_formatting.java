record Point(int x, int y) {
    public String toString() { return "{" + x + " " + y + "}"; }
    public String toStringNamed() { return "{x:" + x + " y:" + y + "}"; }
    public String toStringRepr() { return "Point{x:" + x + ", y:" + y + "}"; }
}

void main() {
    var p = new Point(1, 2);

    // %v equivalent: default representation
    System.out.println(p);

    // %+v equivalent: with field names
    System.out.println(p.toStringNamed());

    // %#v equivalent: Go-syntax style representation
    System.out.println(p.toStringRepr());

    // %T equivalent: type name
    System.out.println(p.getClass().getSimpleName());

    // %t: boolean
    System.out.printf("%b%n", true);

    // %d: integer
    System.out.printf("%d%n", 123);

    // %b: binary
    System.out.println(Integer.toBinaryString(14));

    // %c: character
    System.out.printf("%c%n", 33);

    // %x: hex integer
    System.out.printf("%x%n", 456);

    // %f: float
    System.out.printf("%f%n", 78.9);

    // %e: scientific notation lower
    System.out.printf("%e%n", 123400000.0);

    // %E: scientific notation upper
    System.out.printf("%E%n", 123400000.0);

    // %s: string (the Go source passes "\"string\"" which already contains quotes)
    System.out.printf("%s%n", "\"string\"");

    // %q: quoted string
    System.out.printf("\"%s\"%n", "\\\"string\\\"");

    // %x on string: hex encoding
    System.out.printf("%s%n", bytesToHex("hex this"));

    // %p: pointer equivalent - use identity hash code as hex
    System.out.printf("0x%x%n", System.identityHashCode(p));

    // width formatting for integers
    System.out.printf("|%6d|%6d|%n", 12, 345);

    // width+precision for floats
    System.out.printf("|%6.2f|%6.2f|%n", 1.2, 3.45);

    // left-justify floats
    System.out.printf("|%-6.2f|%-6.2f|%n", 1.2, 3.45);

    // right-justify strings
    System.out.printf("|%6s|%6s|%n", "foo", "b");

    // left-justify strings
    System.out.printf("|%-6s|%-6s|%n", "foo", "b");

    // Sprintf equivalent
    var s = String.format("a %s", "string");
    System.out.println(s);

    // Fprintf to stderr
    System.err.printf("an %s%n", "error");
}

String bytesToHex(String input) {
    var sb = new StringBuilder();
    for (byte b : input.getBytes()) {
        sb.append(String.format("%02x", b));
    }
    return sb.toString();
}
