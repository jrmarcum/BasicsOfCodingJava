void main() {
    System.out.println("FOO: " + System.getenv().getOrDefault("FOO", ""));
    System.out.println("BAR: " + System.getenv().getOrDefault("BAR", ""));

    System.out.println();
    for (String key : System.getenv().keySet()) {
        System.out.println(key);
    }
}
