record Result(int value, String error) {
    boolean ok() { return error == null; }
}

class ArgError extends Exception {
    final int arg;
    final String prob;

    ArgError(int arg, String prob) {
        super(arg + " - " + prob);
        this.arg = arg;
        this.prob = prob;
    }
}

Result f1(int arg) {
    if (arg == 42) {
        return new Result(-1, "can't work with 42");
    }
    return new Result(arg + 3, null);
}

Result f2(int arg) {
    if (arg == 42) {
        return new Result(-1, arg + " - can't work with it");
    }
    return new Result(arg + 3, null);
}

Object f2Custom(int arg) throws ArgError {
    if (arg == 42) {
        throw new ArgError(arg, "can't work with it");
    }
    return arg + 3;
}

void main() {
    for (int i : new int[]{7, 42}) {
        Result r = f1(i);
        if (!r.ok()) {
            System.out.println("f1 failed: " + r.error());
        } else {
            System.out.println("f1 worked: " + r.value());
        }
    }

    for (int i : new int[]{7, 42}) {
        Result r = f2(i);
        if (!r.ok()) {
            System.out.println("f2 failed: " + r.error());
        } else {
            System.out.println("f2 worked: " + r.value());
        }
    }

    try {
        f2Custom(42);
    } catch (ArgError ae) {
        System.out.println(ae.arg);
        System.out.println(ae.prob);
    }
}
