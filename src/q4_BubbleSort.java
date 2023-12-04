import java.util.Scanner;

public class q4_BubbleSort {

    public static void main(String[] args) {
        // Prompt the user to enter a list of integers
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a list of integers separated by spaces: ");
        String input = scanner.nextLine().trim();

        // Split the input into an array of integers
        String[] strNumbers = input.split("\\s+");
        int[] intArray = new int[strNumbers.length];
        for (int i = 0; i < strNumbers.length; i++) {
            intArray[i] = Integer.parseInt(strNumbers[i]);
        }

        // Perform Bubble Sort on the integer array
        bubbleSort(intArray);

        // Print the sorted list
        System.out.println("Sorted List: ");
        for (int num : intArray) {
            System.out.print(num + " ");
        }

        scanner.close();
    }

    // Bubble Sort implementation for integers
    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
