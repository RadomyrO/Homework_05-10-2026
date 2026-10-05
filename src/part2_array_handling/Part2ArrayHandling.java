package part2_array_handling;

import java.util.Random;
import java.util.Scanner;

// Part 2. Array handling
public class Part2ArrayHandling {

    static Scanner sc = new Scanner(System.in);

    // Part 2.1 Input Array
    static int[] inputArray(int len) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            System.out.print("Enter element #" + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    // Part 2.2 Random Array
    static int[] randomArray(int len) {
        Random rnd = new Random();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = rnd.nextInt(100); 
        }
        return arr;
    }

    // Part 2.3 Print Array
    static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    // Part 2.6 Search
    static int search(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) return i;
        }
        return -1; 
    }

    public static void main(String[] args) {

        // Part 2.4 Sum
        System.out.println("=== Sum of array ===");
        System.out.print("How many elements? ");
        int[] arr = inputArray(sc.nextInt());
        System.out.print("Your array: ");
        printArray(arr);
        int sum = 0;
        for (int x : arr) sum += x;
        System.out.println("Sum = " + sum);

        // Part 2.5 Max
        System.out.println("\n=== Largest value ===");
        System.out.print("Array length? ");
        int[] rnd = randomArray(sc.nextInt());
        System.out.print("Random array: ");
        printArray(rnd);
        if (rnd.length == 0) {
            System.out.println("Empty array, no max");
        } else {
            int max = rnd[0];
            for (int x : rnd) {
                if (x > max) max = x;
            }
            System.out.println("Max = " + max);
        }

        // Part 2.6 Search demo
        System.out.println("\n=== Search ===");
        System.out.print("Value to find in random array: ");
        int v = sc.nextInt();
        int idx = search(rnd, v);
        if (idx == -1) System.out.println("Not found (-1)");
        else System.out.println("Found at index " + idx);
    }
}
