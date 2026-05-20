interface Describer {
    String describe();
}

class Base implements Describer {
    int num;

    Base(int num) {
        this.num = num;
    }

    public String describe() {
        return "base with num=" + num;
    }
}

class Container implements Describer {
    Base base;
    String str;

    Container(Base base, String str) {
        this.base = base;
        this.str = str;
    }

    public String describe() {
        return base.describe();
    }
}

void main() {
    Container co = new Container(new Base(1), "some name");

    System.out.printf("co={num: %d, str: %s}%n", co.base.num, co.str);
    System.out.println("also num: " + co.base.num);
    System.out.println("describe: " + co.describe());

    Describer d = co;
    System.out.println("describer: " + d.describe());
}
