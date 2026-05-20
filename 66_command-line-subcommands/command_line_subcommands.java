import java.util.*;

void main(String[] args) {
    if (args.length < 1) {
        System.out.println("expected 'foo' or 'bar' subcommands");
        System.exit(1);
    }

    switch (args[0]) {
        case "foo" -> {
            boolean enable = false;
            String name = "";
            List<String> tail = new ArrayList<>();
            for (int i = 1; i < args.length; i++) {
                String a = args[i];
                if (a.equals("-enable")) enable = true;
                else if (a.startsWith("-name=")) name = a.substring(6);
                else if (a.startsWith("-")) {
                    System.err.println("flag provided but not defined: " + a);
                    System.err.println("Usage of foo:\n  -enable\n        enable\n  -name string\n        name");
                    System.exit(2);
                } else tail.add(a);
            }
            System.out.println("subcommand 'foo'");
            System.out.println("  enable: " + enable);
            System.out.println("  name: " + name);
            System.out.println("  tail: [" + String.join(" ", tail) + "]");
        }
        case "bar" -> {
            int level = 0;
            List<String> tail = new ArrayList<>();
            for (int i = 1; i < args.length; i++) {
                String a = args[i];
                if (a.startsWith("-level=")) level = Integer.parseInt(a.substring(7));
                else if (a.equals("-level") && i + 1 < args.length) level = Integer.parseInt(args[++i]);
                else if (a.startsWith("-")) {
                    System.err.println("flag provided but not defined: " + a);
                    System.err.println("Usage of bar:\n  -level int\n        level");
                    System.exit(2);
                } else tail.add(a);
            }
            System.out.println("subcommand 'bar'");
            System.out.println("  level: " + level);
            System.out.println("  tail: [" + String.join(" ", tail) + "]");
        }
        default -> {
            System.out.println("expected 'foo' or 'bar' subcommands");
            System.exit(1);
        }
    }
}
