record Pair(int a, int b) {}

Pair vals() {
    return new Pair(3, 7);
}

void main() {
    Pair result = vals();
    System.out.println(result.a());
    System.out.println(result.b());

    // If you only want one value, access just that component.
    int c = vals().b();
    System.out.println(c);
}
