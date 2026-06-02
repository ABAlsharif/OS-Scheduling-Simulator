import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Process> processes = new ArrayList<>();

        System.out.print("Enter the number of processes: ");
        int numProcesses = scanner.nextInt();

        for (int i = 1; i <= numProcesses; i++) {
            System.out.print("Enter burst time for P " + i + ": ");
            int bt = scanner.nextInt();

            System.out.print("Enter priority for P" + i + ": ");
            int pr = scanner.nextInt();

            processes.add(new Process("P" + i, bt, pr));
        }

        PriorityScheduler scheduler = new PriorityScheduler();
        scheduler.schedule(processes);
    }
}
