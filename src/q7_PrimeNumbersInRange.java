public class q7_PrimeNumbersInRange {

    public static void main(String[] args) {
        int lowerRange = 0;
        int upperRange = 1000;

        System.out.println("Prime numbers in the range " + lowerRange + " to " + upperRange + ":");
        findAndPrintPrimes(lowerRange, upperRange);
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

    // Function to find and print prime numbers in a given range
    private static void findAndPrintPrimes(int lowerRange, int upperRange) {
        for (int i = lowerRange; i <= upperRange; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
