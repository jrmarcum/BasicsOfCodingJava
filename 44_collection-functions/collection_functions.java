import java.util.*;
import java.util.function.*;
import java.util.stream.*;

int index(List<String> vs, String t) {
    for (int i = 0; i < vs.size(); i++) {
        if (vs.get(i).equals(t)) return i;
    }
    return -1;
}

boolean include(List<String> vs, String t) {
    return index(vs, t) >= 0;
}

boolean any(List<String> vs, Predicate<String> f) {
    for (var v : vs) {
        if (f.test(v)) return true;
    }
    return false;
}

boolean all(List<String> vs, Predicate<String> f) {
    for (var v : vs) {
        if (!f.test(v)) return false;
    }
    return true;
}

List<String> filter(List<String> vs, Predicate<String> f) {
    var result = new ArrayList<String>();
    for (var v : vs) {
        if (f.test(v)) result.add(v);
    }
    return result;
}

List<String> map(List<String> vs, Function<String, String> f) {
    var result = new ArrayList<String>();
    for (var v : vs) result.add(f.apply(v));
    return result;
}

void main() {
    var strs = List.of("peach", "apple", "pear", "plum");

    System.out.println(index(strs, "pear"));

    System.out.println(include(strs, "grape"));

    System.out.println(any(strs, v -> v.startsWith("p")));

    System.out.println(all(strs, v -> v.startsWith("p")));

    System.out.println(filter(strs, v -> v.contains("e")));

    System.out.println(map(strs, String::toUpperCase));
}
