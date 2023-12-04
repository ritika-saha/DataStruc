import java.util.Arrays;
import java.util.Scanner;

public class q6_AnagramDetection {

    public static void main(String[] args) {
        // Prompt the user to enter two strings
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first string: ");
        String str1 = scanner.nextLine().toLowerCase(); // Convert to lowercase for case-insensitive comparison
        System.out.print("Enter the second string: ");
        String str2 = scanner.nextLine().toLowerCase(); // Convert to lowercase for case-insensitive comparison

        // Check if the strings are anagrams
        boolean areAnagrams = checkAnagrams(str1, str2);

        // Print the result
        if (areAnagrams) {
            System.out.println("The two strings are anagrams.");
        } else {
            System.out.println("The two strings are not anagrams.");
        }
        scanner.close();
    }

    // Check if two strings are anagrams
    private static boolean checkAnagrams(String str1, String str2) {
        // Remove spaces and convert the strings to char arrays for easier comparison
        char[] charArray1 = str1.replaceAll("\\s", "").toCharArray();
        char[] charArray2 = str2.replaceAll("\\s", "").toCharArray();

        // Check if the lengths are the same
        if (charArray1.length != charArray2.length) {
            return false;
        }

        // Sort the char arrays
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        // Compare the sorted char arrays
        return Arrays.equals(charArray1, charArray2);
    }
}

