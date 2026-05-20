void main() {
    int i = 1;
    while (i <= 3) {
        System.out.println(i);
        i = i + 1;
    }

    for (int j = 7; j <= 9; j++) {
        System.out.println(j);
    }

    for (;;) {
        System.out.println("loop");
        break;
    }

    for (int n = 0; n <= 5; n++) {
        if (n % 2 == 0) {
            continue;
        }
        System.out.println(n);
    }
}
