import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q21_PrimeAnagramRange {

    public static void main(String[] args) {
        int lowerRange = 0;
        int upperRange = 1000;

        // Find and store prime numbers in the range
        List<Integer> primes = findPrimes(lowerRange, upperRange);

        // Separate prime numbers into anagrams and non-anagrams
        List<Integer> anagramPrimes = new ArrayList<>();
        List<Integer> nonAnagramPrimes = new ArrayList<>();

        for (int i = 0; i < primes.size(); i++) {
            for (int j = i + 1; j < primes.size(); j++) {
                if (areAnagrams(primes.get(i), primes.get(j))) {
                    anagramPrimes.add(primes.get(i));
                    anagramPrimes.add(primes.get(j));
                }
            }
            if (!anagramPrimes.contains(primes.get(i))) {
                nonAnagramPrimes.add(primes.get(i));
            }
        }

        // Store anagram and non-anagram primes in a 2D array
        int[][] primeAnagramArray = new int[2][];
        primeAnagramArray[0] = listToArray(anagramPrimes);
        primeAnagramArray[1] = listToArray(nonAnagramPrimes);

        // Display the 2D array
        displayPrimeAnagramArray(primeAnagramArray);
    }

    // Function to find prime numbers in a given range
    private static List<Integer> findPrimes(int lowerRange, int upperRange) {
        List<Integer> primes = new ArrayList<>();
        for (int i = lowerRange; i <= upperRange; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }

    // Function to check if two numbers are anagrams
    private static boolean areAnagrams(int num1, int num2) {
        char[] charArray1 = Integer.toString(num1).toCharArray();
        char[] charArray2 = Integer.toString(num2).toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return Arrays.equals(charArray1, charArray2);
    }

    // Function to convert a list of integers to an array
    private static int[] listToArray(List<Integer> list) {
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    // Function to display the 2D array
    private static void displayPrimeAnagramArray(int[][] primeAnagramArray) {
        System.out.println("Prime Numbers that are Anagrams:");
        displayArray(primeAnagramArray[0]);

        System.out.println("\nPrime Numbers that are not Anagrams:");
        displayArray(primeAnagramArray[1]);
    }

    // Function to display an array
    private static void displayArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
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
}
