interface Geometry {
    double area();
    double perim();
}

class Rect implements Geometry {
    double width, height;

    Rect(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perim() {
        return 2 * width + 2 * height;
    }

    @Override
    public String toString() {
        return "{" + (int) width + " " + (int) height + "}";
    }
}

class Circle implements Geometry {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perim() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "{" + (int) radius + "}";
    }
}

void measure(Geometry g) {
    System.out.println(g);
    System.out.println(g.area());
    System.out.println(g.perim());
}

void main() {
    Rect r = new Rect(3, 4);
    Circle c = new Circle(5);

    measure(r);
    measure(c);
}
