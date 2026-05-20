int plus(int a, int b) {
    return a + b;
}

int plusPlus(int a, int b, int c) {
    return a + b + c;
}

void main() {
    int res = plus(1, 2);
    System.out.println("1+2 = " + res);

    res = plusPlus(1, 2, 3);
    System.out.println("1+2+3 = " + res);
}
