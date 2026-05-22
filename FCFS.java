import java.util.Scanner;

public class FCFS {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int numberOfProcesses;
        int[] burstTime;
        int[] waitingTime;
        int[] turnaroundTime;
        float averageWaitingTime;
        float averageTurnaroundTime;
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;

        System.out.println("Enter the number of processes (n):");
        numberOfProcesses = input.nextInt();

        burstTime = new int[numberOfProcesses];
        waitingTime = new int[numberOfProcesses];
        turnaroundTime = new int[numberOfProcesses];

        System.out.println("Enter the Burst Time for each process:");
        for (int i = 0; i < numberOfProcesses; i++) {
            System.out.print("Burst Time for Process P" + (i + 1) + ": ");
            burstTime[i] = input.nextInt();
        }

        waitingTime[0] = 0;
        turnaroundTime[0] = waitingTime[0] + burstTime[0];

        for (int i = 1; i < numberOfProcesses; i++) {
            waitingTime[i] = waitingTime[i - 1] + burstTime[i - 1];

            turnaroundTime[i] = waitingTime[i] + burstTime[i];
        }

        for (int i = 0; i < numberOfProcesses; i++) {
            totalWaitingTime += waitingTime[i];
            totalTurnaroundTime += turnaroundTime[i];
        }

        averageWaitingTime = (float) totalWaitingTime / numberOfProcesses;
        averageTurnaroundTime = (float) totalTurnaroundTime / numberOfProcesses;

        System.out.println("\n- FCFS -");
        System.out.println("Process\t\tBT\t\tWT\t\tTAT");

        for (int i = 0; i < numberOfProcesses; i++) {
            System.out.println("P" + (i + 1) + "\t\t\t" + burstTime[i] + "\t\t" + waitingTime[i] + "\t\t" + turnaroundTime[i]);
        }

        System.out.println("\nTotal Waiting Time: " + totalWaitingTime);
        System.out.println("Average Waiting Time (AVWT): " + averageWaitingTime);
        System.out.println("Average Turnaround Time (AVTAT): " + averageTurnaroundTime);

        System.out.println("\n- Gantt Chart -");

        for (int i = 0; i < numberOfProcesses; i++) {
            System.out.print(" |  P" + (i + 1) + "  ");
        }
        System.out.println(" |");

        System.out.print(turnaroundTime[0] - burstTime[0]);

        for (int i = 0; i < numberOfProcesses; i++) {
            if (turnaroundTime[i] < 10) {
                System.out.print("      " + turnaroundTime[i]);
            } else {
                System.out.print("     " + turnaroundTime[i]);
            }
        }
        System.out.println();

        input.close();
    }
}