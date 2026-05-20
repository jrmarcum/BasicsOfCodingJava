import java.util.LinkedHashMap;

void main() {

    // Here we use a for-each loop to sum the numbers in an array.
    int[] nums = {2, 3, 4};
    int sum = 0;
    for (int num : nums) {
        sum += num;
    }
    System.out.println("sum: " + sum);

    // Iterate with index using a traditional for loop.
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] == 3) {
            System.out.println("index: " + i);
        }
    }

    // LinkedHashMap preserves insertion order (Go map order is nondeterministic).
    var kvs = new LinkedHashMap<String, String>();
    kvs.put("a", "apple");
    kvs.put("b", "banana");
    for (var entry : kvs.entrySet()) {
        System.out.println(entry.getKey() + " -> " + entry.getValue());
    }

    // Iterate over just the keys.
    for (var k : kvs.keySet()) {
        System.out.println("key: " + k);
    }

    // Iterate over string characters with index and code point.
    String s = "go";
    for (int i = 0; i < s.length(); i++) {
        System.out.println(i + " " + s.codePointAt(i));
    }
}
