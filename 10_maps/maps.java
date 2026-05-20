import java.util.LinkedHashMap;

void main() {
    LinkedHashMap<String, Integer> m = new LinkedHashMap<>();

    m.put("k1", 7);
    m.put("k2", 13);

    System.out.println("map: " + m);

    int v1 = m.get("k1");
    System.out.println("v1:  " + v1);

    System.out.println("len: " + m.size());

    m.remove("k2");
    System.out.println("map: " + m);

    boolean prs = m.containsKey("k2");
    System.out.println("prs: " + prs);

    LinkedHashMap<String, Integer> n = new LinkedHashMap<>();
    n.put("foo", 1);
    n.put("bar", 2);
    System.out.println("map: " + n);
}
