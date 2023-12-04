class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    Node top;

    public Stack() {
        this.top = null;
    }

    // Function to push a number onto the stack
    public void push(int data) {
        Node newNode = new Node(data);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    // Function to pop a number from the stack
    public int pop() {
        if (top == null) {
            throw new IllegalStateException("Stack is empty");
        }
        int data = top.data;
        top = top.next;
        return data;
    }

    // Function to check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }
}

public class q22_PrimeAnagramStack {

    public static void main(String[] args) {
        int lowerRange = 0;
        int upperRange = 1000;

        // Create a stack to store prime numbers that are anagrams
        Stack anagramStack = new Stack();

        // Find and push prime numbers that are anagrams onto the stack
        findAndPushAnagramPrimes(anagramStack, lowerRange, upperRange);

        // Print anagrams in reverse order
        System.out.println("Prime Numbers that are Anagrams (in reverse order):");
        printAnagramsInReverseOrder(anagramStack);
    }

    // Function to find prime numbers that are anagrams and push onto the stack
    private static void findAndPushAnagramPrimes(Stack stack, int lowerRange, int upperRange) {
        for (int i = lowerRange; i <= upperRange; i++) {
            for (int j = i + 1; j <= upperRange; j++) {
                if (isPrime(i) && isPrime(j) && areAnagrams(i, j)) {
                    stack.push(i);
                    stack.push(j);
                }
            }
        }
    }

    // Function to check if two numbers are anagrams
    private static boolean areAnagrams(int num1, int num2) {
        char[] charArray1 = Integer.toString(num1).toCharArray();
        char[] charArray2 = Integer.toString(num2).toCharArray();

        java.util.Arrays.sort(charArray1);
        java.util.Arrays.sort(charArray2);

        return java.util.Arrays.equals(charArray1, charArray2);
    }

    // Function to print the stack in reverse order
    private static void printAnagramsInReverseOrder(Stack stack) {
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
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
