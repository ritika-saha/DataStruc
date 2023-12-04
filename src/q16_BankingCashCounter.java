import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q16_BankingCashCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a Queue to simulate people in the cash counter
        Queue<Customer> customerQueue = new LinkedList<>();

        // Initial cash balance
        int cashBalance = 10000; // You can set any initial cash balance

        while (true) {
            System.out.println("Banking Cash Counter Simulation");
            System.out.println("1. Enqueue (Add customer)");
            System.out.println("2. Dequeue (Process customer)");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Enqueue (Add customer)
                    System.out.println("Enter customer details:");
                    System.out.print("Name: ");
                    String name = scanner.next();
                    System.out.print("Amount: ");
                    int amount = scanner.nextInt();
                    System.out.print("Transaction Type (D for Deposit, W for Withdraw): ");
                    char transactionType = scanner.next().charAt(0);

                    // Create a new customer and enqueue
                    Customer customer = new Customer(name, amount, transactionType);
                    customerQueue.add(customer);
                    System.out.println(name + " added to the queue.");
                    break;

                case 2:
                    // Dequeue (Process customer)
                    if (!customerQueue.isEmpty()) {
                        Customer dequeuedCustomer = customerQueue.poll();
                        processCustomer(dequeuedCustomer, cashBalance);
                    } else {
                        System.out.println("Queue is empty. No customers to process.");
                    }
                    break;

                case 3:
                    // Exit
                    System.out.println("Exiting the Banking Cash Counter Simulation.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    // Process the customer (Deposit or Withdraw)
    private static void processCustomer(Customer customer, int cashBalance) {
        int amount = customer.getAmount();
        char transactionType = customer.getTransactionType();

        if (transactionType == 'D') {
            cashBalance += amount;
            System.out.println(customer.getName() + " deposited $" + amount + ". Current Cash Balance: $" + cashBalance);
        } else if (transactionType == 'W') {
            if (amount <= cashBalance) {
                cashBalance -= amount;
                System.out.println(customer.getName() + " withdrew $" + amount + ". Current Cash Balance: $" + cashBalance);
            } else {
                System.out.println("Insufficient funds for withdrawal by " + customer.getName());
            }
        }
    }

    // Class representing a customer
    static class Customer {
        private String name;
        private int amount;
        private char transactionType;

        public Customer(String name, int amount, char transactionType) {
            this.name = name;
            this.amount = amount;
            this.transactionType = transactionType;
        }

        public String getName() {
            return name;
        }

        public int getAmount() {
            return amount;
        }

        public char getTransactionType() {
            return transactionType;
        }
    }
}
