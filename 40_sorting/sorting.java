import java.util.*;

void main() {
    var strs = new ArrayList<>(List.of("c", "a", "b"));
    Collections.sort(strs);
    System.out.println("Strings: " + strs);

    var ints = new ArrayList<>(List.of(7, 2, 4));
    Collections.sort(ints);
    System.out.println("Ints:    " + ints);

    var sorted = new ArrayList<>(ints);
    Collections.sort(sorted);
    System.out.println("Sorted:  " + ints.equals(sorted));
}
