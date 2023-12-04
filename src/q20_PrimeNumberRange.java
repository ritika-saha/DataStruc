import java.util.Arrays;

public class q20_PrimeNumberRange {

    public static void main(String[] args) {
        int lowerRange = 0;
        int upperRange = 1000;

        // Define the size of the 2D array based on the ranges
        int numberOfRanges = (upperRange / 100) + 1;
        int[][] primeNumberArray = new int[numberOfRanges][];

        // Find and store prime numbers in the 2D array
        findAndStorePrimes(primeNumberArray, lowerRange, upperRange);

        // Display the prime numbers in each range
        displayPrimeNumberArray(primeNumberArray);
    }

    // Function to find and store prime numbers in a 2D array
    private static void findAndStorePrimes(int[][] primeNumberArray, int lowerRange, int upperRange) {
        for (int i = 0; i < primeNumberArray.length; i++) {
            // Calculate the range for each dimension
            int startRange = i * 100;
            int endRange = startRange + 100;

            // Find prime numbers in the current range
            primeNumberArray[i] = findPrimesInRange(startRange, endRange, lowerRange, upperRange);
        }
    }

    // Function to find prime numbers in a given range
    private static int[] findPrimesInRange(int startRange, int endRange, int lowerRange, int upperRange) {
        // Create a dynamic array to store prime numbers
        int[] primes = new int[upperRange / 10];
        int index = 0;

        // Iterate through numbers in the range
        for (int num = Math.max(startRange, lowerRange); num <= Math.min(endRange, upperRange); num++) {
            if (isPrime(num)) {
                primes[index++] = num;
            }
        }

        // Trim the array to the actual number of prime numbers found
        return Arrays.copyOf(primes, index);
    }

    // Function to check if a number is prime
    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    // Function to display the 2D array containing prime numbers
    private static void displayPrimeNumberArray(int[][] primeNumberArray) {
        for (int i = 0; i < primeNumberArray.length; i++) {
            System.out.print("Range " + (i * 100) + "-" + ((i + 1) * 100 - 1) + ": ");
            for (int prime : primeNumberArray[i]) {
                System.out.print(prime + " ");
            }
            System.out.println();
        }
    }
}

