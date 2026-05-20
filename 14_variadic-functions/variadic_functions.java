import java.util.stream.IntStream;

void sum(int... nums) {
    // Convert to boxed list for printing in [1, 2, 3] format.
    var list = IntStream.of(nums).boxed().toList();
    System.out.print(list + " ");
    int total = 0;
    for (int num : nums) {
        total += num;
    }
    System.out.println(total);
}

void main() {
    sum(1, 2);
    sum(1, 2, 3);

    int[] nums = {1, 2, 3, 4};
    sum(nums);
}
