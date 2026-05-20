import java.util.Arrays;

void main(String[] args) {
    var argsWithProg = new String[args.length + 1];
    argsWithProg[0] = "command_line_arguments";
    System.arraycopy(args, 0, argsWithProg, 1, args.length);

    System.out.println(Arrays.asList(argsWithProg));
    System.out.println(Arrays.asList(args));
    System.out.println(args[2]);
}
