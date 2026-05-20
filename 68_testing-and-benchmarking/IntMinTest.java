public class IntMinTest {

    static int intMin(int a, int b) {
        return a < b ? a : b;
    }

    static int pass = 0, fail = 0;

    static void run(String name, Runnable test) {
        System.out.println("=== RUN   " + name);
        try {
            test.run();
            System.out.printf("--- PASS: %s (0.00s)%n", name);
            pass++;
        } catch (AssertionError e) {
            System.out.printf("--- FAIL: %s (0.00s)%n", name);
            System.out.println("    " + e.getMessage());
            fail++;
        }
    }

    static void assertEqual(int got, int want, String msg) {
        if (got != want) throw new AssertionError(msg + ": got " + got + ", want " + want);
    }

    public static void main(String[] args) {
        run("TestIntMinBasic", () -> {
            assertEqual(intMin(2, -2), -2, "intMin(2,-2)");
        });

        int[][] tests = {{0,1,0},{1,0,0},{2,-2,-2},{0,-1,-1},{-1,0,-1}};
        String[] names = {"0,1","1,0","2,-2","0,-1","-1,0"};
        System.out.println("=== RUN   TestIntMinTableDriven");
        boolean tablePass = true;
        for (int i = 0; i < tests.length; i++) {
            System.out.println("=== RUN   TestIntMinTableDriven/" + names[i]);
            int got = intMin(tests[i][0], tests[i][1]);
            if (got == tests[i][2]) {
                System.out.printf("    --- PASS: TestIntMinTableDriven/%s (0.00s)%n", names[i]);
            } else {
                System.out.printf("    --- FAIL: TestIntMinTableDriven/%s (0.00s)%n", names[i]);
                System.out.printf("        got %d, want %d%n", got, tests[i][2]);
                tablePass = false;
            }
        }
        if (tablePass) {
            System.out.printf("--- PASS: TestIntMinTableDriven (0.00s)%n");
            pass++;
        } else {
            System.out.printf("--- FAIL: TestIntMinTableDriven (0.00s)%n");
            fail++;
        }

        if (fail == 0) {
            System.out.println("PASS");
            System.out.printf("ok  \tIntMinTest\t0.000s%n");
        } else {
            System.out.println("FAIL");
            System.exit(1);
        }
    }
}
