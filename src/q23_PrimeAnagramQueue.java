class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    Node front, rear;

    public Queue() {
        this.front = this.rear = null;
    }

    // Function to enqueue (add) a number to the queue
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (this.rear == null) {
            this.front = this.rear = newNode;
        } else {
            this.rear.next = newNode;
            this.rear = newNode;
        }
    }

    // Function to dequeue (remove) a number from the queue
    public int dequeue() {
        if (this.front == null) {
            throw new IllegalStateException("Queue is empty");
        }
        int data = this.front.data;
        this.front = this.front.next;
        if (this.front == null) {
            this.rear = null;
        }
        return data;
    }

    // Function to check if the queue is empty
    public boolean isEmpty() {
        return this.front == null;
    }
}

public class q23_PrimeAnagramQueue {

    public static void main(String[] args) {
        int lowerRange = 0;
        int upperRange = 1000;

        // Create a queue to store prime numbers that are anagrams
        Queue anagramQueue = new Queue();

        // Find and enqueue prime numbers that are anagrams into the queue
        findAndEnqueueAnagramPrimes(anagramQueue, lowerRange, upperRange);

        // Print anagrams from the queue
        System.out.println("Prime Numbers that are Anagrams (from the queue):");
        printAnagramsFromQueue(anagramQueue);
    }

    // Function to find prime numbers that are anagrams and enqueue into the queue
    private static void findAndEnqueueAnagramPrimes(Queue queue, int lowerRange, int upperRange) {
        for (int i = lowerRange; i <= upperRange; i++) {
            for (int j = i + 1; j <= upperRange; j++) {
                if (isPrime(i) && isPrime(j) && areAnagrams(i, j)) {
                    queue.enqueue(i);
                    queue.enqueue(j);
                }
            }
        }
    }

    // Function to print anagrams from the queue
    private static void printAnagramsFromQueue(Queue queue) {
        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
        System.out.println();
    }

    // Function to check if two numbers are anagrams
    private static boolean areAnagrams(int num1, int num2) {
        char[] charArray1 = Integer.toString(num1).toCharArray();
        char[] charArray2 = Integer.toString(num2).toCharArray();

        java.util.Arrays.sort(charArray1);
        java.util.Arrays.sort(charArray2);

        return java.util.Arrays.equals(charArray1, charArray2);
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

