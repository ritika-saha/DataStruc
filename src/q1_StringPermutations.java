import java.util.Arrays;

public class q1_StringPermutations {

    // Iterative method to generate all permutations of a string
    public static String[] generatePermutationsIterative(String input) {
        int n = input.length();
        int[] indexes = new int[n];
        Arrays.fill(indexes, 0);
        char[] characters = input.toCharArray();
        String[] result = new String[factorial(n)];
        int count = 0;

        while (count < factorial(n)) {
            result[count] = new String(characters);

            int i = 0;
            while (i < n) {
                if (indexes[i] < i) {
                    swap(characters, i % 2 == 0 ? 0 : indexes[i], i);
                    indexes[i]++;
                    break;
                } else {
                    indexes[i] = 0;
                    i++;
                }
            }
            count++;
        }

        return result;
    }

    // Recursive method to generate all permutations of a string
    public static String[] generatePermutationsRecursive(String input) {
        return generatePermutationsRecursiveHelper(input.toCharArray(), input.length());
    }

    private static String[] generatePermutationsRecursiveHelper(char[] characters, int n) {
        String[] result = new String[factorial(n)];
        if (n == 1) {
            result[0] = new String(characters);
        } else {
            for (int i = 0; i < n; i++) {
                swap(characters, i, n - 1);
                String[] subResult = generatePermutationsRecursiveHelper(characters, n - 1);
                System.arraycopy(subResult, 0, result, i * factorial(n - 1), factorial(n - 1));
                swap(characters, i, n - 1);
            }
        }
        return result;
    }

    // Helper method to swap characters in a char array
    private static void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Helper method to calculate factorial
    private static int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Check if two arrays of strings are equal
    public static boolean areArraysEqual(String[] arr1, String[] arr2) {
        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        String input = "rit";

        // Generate permutations using iterative method
        String[] iterativePermutations = generatePermutationsIterative(input);

        // Generate permutations using recursive method
        String[] recursivePermutations = generatePermutationsRecursive(input);

        // Sort the arrays
        Arrays.sort(iterativePermutations);
        Arrays.sort(recursivePermutations);

        // Check if the arrays are equal
        boolean isEqual = areArraysEqual(iterativePermutations, recursivePermutations);

        // Display the results
        System.out.println("Iterative Permutations: " + Arrays.toString(iterativePermutations));
        System.out.println("Recursive Permutations: " + Arrays.toString(recursivePermutations));
        System.out.println("Are arrays equal? " + isEqual);
    }
}

