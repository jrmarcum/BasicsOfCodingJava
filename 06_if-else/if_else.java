void main() {
    if (7 % 2 == 0) {
        System.out.println("7 is even");
    } else {
        System.out.println("7 is odd");
    }

    if (8 % 4 == 0) {
        System.out.println("8 is divisible by 4");
    }

    int num = 9;
    if (num < 0) {
        System.out.println(num + " is negative");
    } else if (num < 10) {
        System.out.println(num + " has 1 digit");
    } else {
        System.out.println(num + " has multiple digits");
    }
}
