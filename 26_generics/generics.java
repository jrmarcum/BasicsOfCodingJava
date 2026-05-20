import java.util.ArrayList;
import java.util.List;

class MyList<T> {
    private static class Element<T> {
        T val;
        Element<T> next;
        Element(T val) { this.val = val; }
    }

    private Element<T> head;
    private Element<T> tail;

    void push(T v) {
        Element<T> e = new Element<>(v);
        if (tail == null) {
            head = e;
            tail = e;
        } else {
            tail.next = e;
            tail = e;
        }
    }

    List<T> allElements() {
        List<T> elems = new ArrayList<>();
        for (Element<T> e = head; e != null; e = e.next) {
            elems.add(e.val);
        }
        return elems;
    }
}

<T extends Comparable<T>> int slicesIndex(List<T> s, T v) {
    for (int i = 0; i < s.size(); i++) {
        if (v.compareTo(s.get(i)) == 0) {
            return i;
        }
    }
    return -1;
}

void main() {
    List<String> s = List.of("foo", "bar", "zoo");
    System.out.println("index of zoo: " + slicesIndex(s, "zoo"));

    MyList<Integer> lst = new MyList<>();
    lst.push(10);
    lst.push(13);
    lst.push(23);
    System.out.println("list: " + lst.allElements());
}
