import java.util.Arrays;

void main() {
    int[] a = new int[5];
    System.out.println("emp: " + Arrays.toString(a));

    a[4] = 100;
    System.out.println("set: " + Arrays.toString(a));
    System.out.println("get: " + a[4]);

    System.out.println("len: " + a.length);

    int[] b = {1, 2, 3, 4, 5};
    System.out.println("dcl: " + Arrays.toString(b));

    int[][] twoD = new int[2][3];
    for (int row = 0; row < 2; row++) {
        for (int col = 0; col < 3; col++) {
            twoD[row][col] = row + col;
        }
    }
    System.out.println("2d:  " + Arrays.deepToString(twoD));
}
