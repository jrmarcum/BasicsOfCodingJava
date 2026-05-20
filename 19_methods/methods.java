class Rect {
    int width, height;

    Rect(int width, int height) {
        this.width = width;
        this.height = height;
    }

    int area() {
        return width * height;
    }

    int perim() {
        return 2 * width + 2 * height;
    }
}

void main() {
    Rect r = new Rect(10, 5);

    System.out.println("area:  " + r.area());
    System.out.println("perim: " + r.perim());

    // Java objects are already references — same methods work via reference.
    Rect rp = r;
    System.out.println("area:  " + rp.area());
    System.out.println("perim: " + rp.perim());
}
