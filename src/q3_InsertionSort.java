import java.util.Scanner;

public class q3_InsertionSort {

    public static void main(String[] args) {
        // Prompt the user to enter a list of words
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a list of words separated by spaces: ");
        String input = scanner.nextLine().trim();

        // Split the input into an array of words
        String[] wordList = input.split("\\s+");

        // Perform Insertion Sort on the word list
        insertionSort(wordList);

        // Print the sorted list
        System.out.println("Sorted List: ");
        for (String word : wordList) {
            System.out.print(word + " ");
        }
    }

    // Insertion Sort implementation for strings
    private static void insertionSort(String[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            String key = arr[i];
            int j = i - 1;

            // Move elements of arr[0..i-1] that are greater than key to one position ahead of their current position
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}
