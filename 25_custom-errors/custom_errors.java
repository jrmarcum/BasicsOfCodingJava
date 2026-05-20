class ArgError extends Exception {
    final int arg;
    final String message;

    ArgError(int arg, String message) {
        super(arg + " - " + message);
        this.arg = arg;
        this.message = message;
    }
}

int f(int arg) throws ArgError {
    if (arg == 42) {
        throw new ArgError(arg, "can't work with it");
    }
    return arg + 3;
}

void main() {
    try {
        f(42);
    } catch (Exception err) {
        if (err instanceof ArgError ae) {
            System.out.println(ae.arg);
            System.out.println(ae.message);
        } else {
            System.out.println("err doesn't match ArgError");
        }
    }
}
