/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.roundrobin;

import java.util.Scanner;

public class RoundRobinScheduling {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: number of processes
        System.out.print("Enter the number of processes: ");
        int n = scanner.nextInt();

        int[] burstTime = new int[n];
        int[] remainingTime = new int[n];
        int[] waitingTime = new int[n];
        int[] turnaroundTime = new int[n];

        // Input: burst time for each process
        for (int i = 0; i < n; i++) {
            System.out.print("Enter burst time for process " + (i + 1) + ": ");
            burstTime[i] = scanner.nextInt();
            remainingTime[i] = burstTime[i]; // initialize remaining time
        }

        // Input: time quantum
        System.out.print("Enter time quantum: ");
        int timeQuantum = scanner.nextInt();

        // Round Robin scheduling
        int currentTime = 0;
        boolean done;

        do {
            done = true;
            for (int i = 0; i < n; i++) {
                if (remainingTime[i] > 0) {
                    done = false; // At least one process is still left

                    if (remainingTime[i] > timeQuantum) {
                        currentTime += timeQuantum;
                        remainingTime[i] -= timeQuantum;
                    } else {
                        currentTime += remainingTime[i];
                        waitingTime[i] = currentTime - burstTime[i];
                        remainingTime[i] = 0;
                    }
                }
            }
        } while (!done);

        // Calculate turnaround time
        for (int i = 0; i < n; i++) {
            turnaroundTime[i] = burstTime[i] + waitingTime[i];
        }

        // Output: waiting and turnaround times
        System.out.println("\nProcess\tBurst Time\tWaiting Time\tTurnaround Time");
        for (int i = 0; i < n; i++) {
            System.out.printf("P%d\t\t%d\t\t%d\t\t%d\n", (i + 1), burstTime[i], waitingTime[i], turnaroundTime[i]);
        }

        scanner.close();
    }
}
