import java.util.*;

void main(String[] args) {
    String word = "foo";
    int numb = 42;
    boolean fork = false;
    String svar = "bar";
    List<String> tail = new ArrayList<>();

    for (int i = 0; i < args.length; i++) {
        String a = args[i];
        if (a.startsWith("-word=")) word = a.substring(6);
        else if (a.startsWith("-numb=")) numb = Integer.parseInt(a.substring(6));
        else if (a.equals("-fork")) fork = true;
        else if (a.startsWith("-svar=")) svar = a.substring(6);
        else if (a.equals("-h") || a.equals("--help")) {
            System.err.println("  -fork\n        a bool");
            System.err.println("  -numb int\n        an int (default 42)");
            System.err.println("  -svar string\n        a string var (default \"bar\")");
            System.err.println("  -word string\n        a string (default \"foo\")");
            return;
        } else if (a.startsWith("-")) {
            System.err.println("flag provided but not defined: " + a);
            System.err.println("Usage of command_line_flags:");
            System.err.println("  -fork\n        a bool");
            System.err.println("  -numb int\n        an int (default 42)");
            System.err.println("  -svar string\n        a string var (default \"bar\")");
            System.err.println("  -word string\n        a string (default \"foo\")");
            System.exit(2);
        } else {
            tail.add(a);
        }
    }

    System.out.println("word: " + word);
    System.out.println("numb: " + numb);
    System.out.println("fork: " + fork);
    System.out.println("svar: " + svar);
    System.out.println("tail: [" + String.join(" ", tail) + "]");
}
