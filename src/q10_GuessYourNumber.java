import java.util.Scanner;

public class q10_GuessYourNumber {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java GuessYourNumber <N>");
            return;
        }

        int N = Integer.parseInt(args[0]);
        int low = 0;
        int high = N - 1;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Think of a number between 0 and " + (N - 1) + ". I will try to guess it.");

        // Guess the number using binary search
        int guessedNumber = guessNumber(low, high, scanner);

        // Print the final result
        System.out.println("The number you were thinking of is: " + guessedNumber);
    }

    // Recursive function to guess the number using binary search
    private static int guessNumber(int low, int high, Scanner scanner) {
        if (low <= high) {
            int mid = low + (high - low) / 2;

            System.out.print("Is the number between " + low + " and " + mid + "? (true/false): ");
            boolean response = scanner.nextBoolean();

            if (response) {
                // The number is in the lower half
                return guessNumber(low, mid - 1, scanner);
            } else {
                // The number is in the upper half
                return guessNumber(mid + 1, high, scanner);
            }
        } else {
            // Final guess
            return low;
        }
    }
}
