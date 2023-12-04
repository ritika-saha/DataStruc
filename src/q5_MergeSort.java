import java.util.Scanner;

public class q5_MergeSort {

    public static void main(String[] args) {
        // Prompt the user to enter a list of strings
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a list of strings separated by spaces: ");
        String input = scanner.nextLine().trim();

        // Split the input into an array of strings
        String[] stringArray = input.split("\\s+");

        // Perform Merge Sort on the string array
        mergeSort(stringArray, 0, stringArray.length - 1);

        // Print the sorted list
        System.out.println("Sorted List: ");
        for (String str : stringArray) {
            System.out.print(str + " ");
        }

        scanner.close();
    }

    // Merge Sort implementation for strings
    private static void mergeSort(String[] arr, int lo, int hi) {
        if (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            // Recursively sort the two halves
            mergeSort(arr, lo, mid);
            mergeSort(arr, mid + 1, hi);

            // Merge the sorted halves
            merge(arr, lo, mid, hi);
        }
    }

    // Merge two halves of an array
    private static void merge(String[] arr, int lo, int mid, int hi) {
        int n1 = mid - lo + 1;
        int n2 = hi - mid;

        // Create temporary arrays
        String[] leftArray = new String[n1];
        String[] rightArray = new String[n2];

        // Copy data to temporary arrays
        System.arraycopy(arr, lo, leftArray, 0, n1);
        System.arraycopy(arr, mid + 1, rightArray, 0, n2);

        // Merge the two arrays
        int i = 0, j = 0, k = lo;
        while (i < n1 && j < n2) {
            if (leftArray[i].compareTo(rightArray[j]) <= 0) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArray
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
}

