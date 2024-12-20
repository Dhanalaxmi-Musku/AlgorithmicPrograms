import java.util.*;

public class TaskScheduler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of tasks:");
        int n = scanner.nextInt();
        Task[] tasks = new Task[n];
        System.out.println("Enter the deadline for task and minutes to accomplish task :");
        for (int i = 0; i < n; i++) {
            int D = scanner.nextInt();
            int M = scanner.nextInt();
            tasks[i] = new Task(D, M);
        }

        Arrays.sort(tasks, Comparator.comparingInt(t -> t.D));

        int totalTime = 0;
        int maxOvershoot = 0;

        for (int i = 0; i < n; i++) {
            totalTime += tasks[i].M;
            int overshoot = totalTime - tasks[i].D;
            maxOvershoot = Math.max(maxOvershoot, Math.max(0, overshoot));
        }

        System.out.println(maxOvershoot);
    }

    static class Task {
        int D, M;

        Task(int D, int M) {
            this.D = D;
            this.M = M;
        }
    }
}
