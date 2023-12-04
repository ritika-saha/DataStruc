import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class q17_PalindromeChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input a string
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        // Check if the string is a palindrome
        boolean isPalindrome = checkPalindrome(inputString);

        // Output the result
        if (isPalindrome) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
    }

    // Check if the string is a palindrome
    private static boolean checkPalindrome(String str) {
        // Create a deque to store characters
        Deque<Character> deque = new ArrayDeque<>();

        // Add each character to the rear of the deque
        for (char ch : str.toCharArray()) {
            deque.addLast(ch);
        }

        // Process the string from left to right
        while (deque.size() > 1) {
            // Remove characters from the front and rear of the deque
            char frontChar = deque.removeFirst();
            char rearChar = deque.removeLast();

            // Compare the characters
            if (frontChar != rearChar) {
                return false; // Not a palindrome
            }
        }

        return true; // Palindrome
    }
}
