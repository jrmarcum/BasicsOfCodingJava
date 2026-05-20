import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

void main() {
    ArrayList<String> s = new ArrayList<>(Arrays.asList("", "", ""));
    System.out.println("emp: " + s);

    s.set(0, "a");
    s.set(1, "b");
    s.set(2, "c");
    System.out.println("set: " + s);
    System.out.println("get: " + s.get(2));

    System.out.println("len: " + s.size());

    s.add("d");
    s.addAll(Arrays.asList("e", "f"));
    System.out.println("apd: " + s);

    ArrayList<String> c = new ArrayList<>(s);
    System.out.println("cpy: " + c);

    List<String> l = s.subList(2, 5);
    System.out.println("sl1: " + l);

    l = s.subList(0, 5);
    System.out.println("sl2: " + l);

    l = s.subList(2, s.size());
    System.out.println("sl3: " + l);

    ArrayList<String> t = new ArrayList<>(Arrays.asList("g", "h", "i"));
    System.out.println("dcl: " + t);

    ArrayList<ArrayList<Integer>> twoD = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
        int innerLen = i + 1;
        ArrayList<Integer> inner = new ArrayList<>();
        for (int j = 0; j < innerLen; j++) {
            inner.add(i + j);
        }
        twoD.add(inner);
    }
    System.out.println("2d:  " + twoD);
}
