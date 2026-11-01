import java.io.File;
import java.util.Scanner;

public class Main {

    // Rid's algorithm: insertion sort in descending order.
    // Only the first 'passes' insertions are done, then the method stops.
    public static void insertionSort(int[] arr, int passes) {
        for (int i = 1; i <= passes; i++) {
            int key = arr[i];
            int j = i - 1;

            // Shift every element on the left that is smaller than key
            // one position to the right.
            while (j >= 0 && arr[j] < key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Put key in the empty position.
            arr[j + 1] = key;
        }
    }

    // Linear search from index 0. Returns the index, or -1 if not found.
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("branches.txt"));

        int n = sc.nextInt();
        int[] branches = new int[n];
        for (int i = 0; i < n; i++) {
            branches[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = sc.nextInt();
        }

        sc.close();

        // Rid only dares to run exactly 3 passes.
        insertionSort(branches, 3);

        // Print the array after the 3 passes.
        for (int i = 0; i < branches.length; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(branches[i]);
        }
        System.out.println();

        // Search each target in the order they appear in the file.
        for (int i = 0; i < targets.length; i++) {
            int index = linearSearch(branches, targets[i]);
            if (index != -1) {
                System.out.println(targets[i] + ": FOUND at index " + index);
            } else {
                System.out.println(targets[i] + ": NOT FOUND");
            }
        }
    }
}
