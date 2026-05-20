import java.util.*;

void main() {
    var fruits = new ArrayList<>(List.of("peach", "banana", "kiwi"));
    fruits.sort(Comparator.comparingInt(String::length));
    System.out.println(fruits);
}
