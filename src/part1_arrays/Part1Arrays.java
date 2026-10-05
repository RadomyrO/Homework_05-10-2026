package part1_arrays;

// Part 1. Array Syntax
public class Part1Arrays {

    public static void main(String[] args) {

        // Part 1.1 Creation

        // fixed size
        int[] a = new int[10];

        // size from var
        int size = 5;
        double[] d = new double[size];

        // literals
        int[] nums = {1, 4, 2, 8, 5};
        String[] names = {"Bob", "Alice", "Tom"};
        char[] chars = {'j', 'a', 'v', 'a'};
        boolean[] flags = {true, false, true};

        // Part 1.2 length
        System.out.println("a.length = " + a.length);
        System.out.println("d.length = " + d.length);
        System.out.println("nums.length = " + nums.length);
        System.out.println("names.length = " + names.length);
        System.out.println("chars.length = " + chars.length);
        System.out.println("flags.length = " + flags.length);

        // Part 1.3 set/get by index
        a[4] = 45;
        d[0] = 3.14;
        names[1] = "Kate";
        System.out.println("5th element value: " + a[4]);
        System.out.println("d[0] = " + d[0]);
        System.out.println("names[1] = " + names[1]);
        System.out.println("chars[0] = " + chars[0]);
        System.out.println("flags[1] = " + flags[1]);

        // Part 1.4 traversal

        // for
        System.out.print("for: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        // foreach
        System.out.print("foreach: ");
        for (String name : names) {
            System.out.print(name + " ");
        }
        System.out.println();

        // while
        System.out.print("while: ");
        int i = 0;
        while (i < chars.length) {
            System.out.print(chars[i] + " ");
            i++;
        }
        System.out.println();

        // Part 1.5 error - bad index (crashes here, screenshot it)
        System.out.println("a[1000] = " + a[1000]);
    }
}
