import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class q11_TaskScheduling {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of tasks
        System.out.print("Enter the number of tasks: ");
        int numTasks = scanner.nextInt();

        Task[] tasks = new Task[numTasks];

        // Input the deadline and minutes for each task
        System.out.println("Enter the deadline and minutes for each task:");

        for (int i = 0; i < numTasks; i++) {
            int deadline = scanner.nextInt();
            int minutes = scanner.nextInt();
            tasks[i] = new Task(deadline, minutes);
        }

        // Sort tasks based on their deadlines
        Arrays.sort(tasks, Comparator.comparingInt(Task::getDeadline));

        // Calculate the maximum overshoot for each task
        int maxOvershoot = 0;
        for (int i = 0; i < numTasks; i++) {
            maxOvershoot = Math.max(maxOvershoot, tasks[i].calculateOvershoot());
        }

        // Output the results
        System.out.println("Maximum overshoot for each task:");
        for (int i = 0; i < numTasks; i++) {
            System.out.println(maxOvershoot);
        }
    }

    // Class representing a task
    static class Task {
        int deadline;
        int minutes;

        public Task(int deadline, int minutes) {
            this.deadline = deadline;
            this.minutes = minutes;
        }

        public int getDeadline() {
            return deadline;
        }

        // Calculate the overshoot for a task
        public int calculateOvershoot() {
            return Math.max(0, (deadline - minutes));
        }
    }
}
