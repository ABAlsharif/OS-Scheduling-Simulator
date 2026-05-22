/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.process;
import java.util.*;

class Process {
    int id, arrivalTime, burstTime, completionTime, waitingTime, turnaroundTime, remainingTime;

    Process(int id, int arrivalTime, int burstTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
    }
}

public class SJFTypes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: number of processes
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        Process[] processes = new Process[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter Arrival Time for Process " + (i + 1) + ": ");
            int at = sc.nextInt();
            System.out.print("Enter Burst Time for Process " + (i + 1) + ": ");
            int bt = sc.nextInt();
            processes[i] = new Process(i + 1, at, bt);
        }

        // Menu for SJF Type
        System.out.println("\nChoose SJF Type:");
        System.out.println("1. SJF (Default - Non-Preemptive)");
        System.out.println("2. SJF Non-Preemptive");
        System.out.println("3. SJF Preemptive (SRTF)");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                sjf(processes); // Default is Non-Preemptive
                break;
            case 2:
                sjfNonPreemptive(processes);
                break;
            case 3:
                sjfPreemptive(processes);
                break;
            default:
                System.out.println("Invalid choice.");
        }

        sc.close();
    }

    // SJF (Default to Non-Preemptive)
    static void sjf(Process[] proc) {
        System.out.println("\n[SJF - Default (Non-Preemptive)]");
        sjfNonPreemptive(proc);
    }

    // SJF Non-Preemptive
    static void sjfNonPreemptive(Process[] proc) {
        int n = proc.length;
        int completed = 0, currentTime = 0;
        boolean[] isDone = new boolean[n];

        while (completed < n) {
            int idx = -1;
            int minBurst = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (!isDone[i] && proc[i].arrivalTime <= currentTime) {
                    if (proc[i].burstTime < minBurst) {
                        minBurst = proc[i].burstTime;
                        idx = i;
                    }
                }
            }

            if (idx != -1) {
                Process p = proc[idx];
                currentTime += p.burstTime;
                p.completionTime = currentTime;
                p.turnaroundTime = p.completionTime - p.arrivalTime;
                p.waitingTime = p.turnaroundTime - p.burstTime;
                isDone[idx] = true;
                completed++;
            } else {
                currentTime++;
            }
        }

        printResults(proc, "SJF Non-Preemptive");
    }

    // SJF Preemptive (Shortest Remaining Time First)
    static void sjfPreemptive(Process[] proc) {
    int n = proc.length;
    int completed = 0, currentTime = 0;
    boolean[] isDone = new boolean[n];

    List<Integer> ganttProcess = new ArrayList<>();
    List<Integer> ganttTime = new ArrayList<>();

    while (completed < n) {
        int idx = -1;
        int minRemain = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (!isDone[i] && proc[i].arrivalTime <= currentTime && proc[i].remainingTime > 0) {
                if (proc[i].remainingTime < minRemain) {
                    minRemain = proc[i].remainingTime;
                    idx = i;
                }
            }
        }

        if (idx != -1) {
            proc[idx].remainingTime--;
            ganttProcess.add(proc[idx].id); // Track Gantt process
            ganttTime.add(currentTime);     // Track time
            currentTime++;

            if (proc[idx].remainingTime == 0) {
                proc[idx].completionTime = currentTime;
                proc[idx].turnaroundTime = proc[idx].completionTime - proc[idx].arrivalTime;
                proc[idx].waitingTime = proc[idx].turnaroundTime - proc[idx].burstTime;
                isDone[idx] = true;
                completed++;
            }
        } else {
            ganttProcess.add(-1); // CPU Idle
            ganttTime.add(currentTime);
            currentTime++;
        }
    }

    printResults(proc, "SJF Preemptive (SRTF)");
    printGanttChart(ganttProcess, ganttTime, currentTime);
}

    // Print table of results
    static void printResults(Process[] proc, String title) {
        System.out.println("\n" + title + " Scheduling:");
        System.out.println("PID\tAT\tBT\tCT\tTAT\tWT");

        double totalTAT = 0, totalWT = 0;
        for (Process p : proc) {
            System.out.printf("P%d\t%d\t%d\t%d\t%d\t%d\n",
                    p.id, p.arrivalTime, p.burstTime,
                    p.completionTime, p.turnaroundTime, p.waitingTime);
            totalTAT += p.turnaroundTime;
            totalWT += p.waitingTime;
        }

        System.out.printf("\nAverage Turnaround Time: %.2f\n", totalTAT / proc.length);
        System.out.printf("Average Waiting Time: %.2f\n", totalWT / proc.length);
        
        
    }
    // Gantt Chart Printer — must be outside of any other method
static void printGanttChart(List<Integer> procIDs, List<Integer> times, int endTime) {
    System.out.println("\nGantt Chart:");
    System.out.print(" ");

    for (int i = 0; i < procIDs.size(); i++) {
        String label = (procIDs.get(i) == -1) ? "Idle" : "P" + procIDs.get(i);
        System.out.print(" " + label + " |");
    }

    System.out.print("\n0");
    for (int i = 0; i < procIDs.size(); i++) {
        System.out.print(String.format("    %d", times.get(i) + 1));
    }
    System.out.println();
}

}
