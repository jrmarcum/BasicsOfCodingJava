import java.util.*;

void main() {
    System.out.println("Contains:  " + "test".contains("es"));
    System.out.println("Count:     " + "test".chars().filter(c -> c == 't').count());
    System.out.println("HasPrefix: " + "test".startsWith("te"));
    System.out.println("HasSuffix: " + "test".endsWith("st"));
    System.out.println("Index:     " + "test".indexOf("e"));
    System.out.println("Join:      " + String.join("-", "a", "b"));
    System.out.println("Repeat:    " + "a".repeat(5));
    System.out.println("Replace:   " + "foo".replace("o", "0"));
    System.out.println("Replace:   " + "foo".replaceFirst("o", "0"));
    System.out.println("Split:     " + Arrays.toString("a-b-c-d-e".split("-")));
    System.out.println("ToLower:   " + "TEST".toLowerCase());
    System.out.println("ToUpper:   " + "test".toUpperCase());
    System.out.println("Len: " + "hello".length());
    System.out.println("Char:" + (int) "hello".charAt(1));
}
