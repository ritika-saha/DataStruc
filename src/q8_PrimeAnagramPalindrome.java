import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q8_PrimeAnagramPalindrome {

    public static void main(String[] args) {
        int lowerRange = 0;
        int upperRange = 1000;

        System.out.println("Prime numbers in the range " + lowerRange + " to " + upperRange + ":");
        List<Integer> primes = findPrimes(lowerRange, upperRange);
        System.out.println(primes);

        System.out.println("\nPrime numbers that are Anagrams:");
        findAndPrintAnagrams(primes);

        System.out.println("\nPrime numbers that are Palindromes:");
        findAndPrintPalindromes(primes);
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

    // Function to find and print prime numbers that are anagrams
    private static void findAndPrintAnagrams(List<Integer> primes) {
        for (int i = 0; i < primes.size() - 1; i++) {
            for (int j = i + 1; j < primes.size(); j++) {
                if (areAnagrams(primes.get(i), primes.get(j))) {
                    System.out.println(primes.get(i) + " and " + primes.get(j) + " are anagrams.");
                }
            }
        }
    }

    // Function to check if a number is a palindrome
    private static boolean isPalindrome(int number) {
        String strNum = Integer.toString(number);
        return strNum.equals(new StringBuilder(strNum).reverse().toString());
    }

    // Function to find and print prime numbers that are palindromes
    private static void findAndPrintPalindromes(List<Integer> primes) {
        for (int prime : primes) {
            if (isPalindrome(prime)) {
                System.out.println(prime + " is a palindrome.");
            }
        }
    }
}
