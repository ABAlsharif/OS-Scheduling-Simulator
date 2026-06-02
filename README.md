# OS Scheduling Simulator

A comprehensive Java-based simulator that implements various Central Processing Unit (CPU) scheduling algorithms. This project demonstrates core Operating Systems (OS) concepts, including process management, scheduling criteria, and performance evaluation metrics like Average Waiting Time (AVGWT) and Average Turnaround Time (AVGTAT).

## 🚀 Implemented Algorithms

1. **First-Come, First-Served (FCFS)**
   * Non-preemptive algorithm that executes processes in the strict order of their arrival. Includes a built-in text-based **Gantt Chart** generator.
2. **Shortest Job First (SJF)**
   * **Non-Preemptive:** Selects the process with the shortest burst time execution.
   * **Preemptive (SRTF - Shortest Remaining Time First):** Interrupts the current process if a new process arrives with a shorter remaining burst time. Includes a dynamic **Gantt Chart** generator.
3. **Priority Scheduling (Non-Preemptive)**
   * Schedules processes based on priority weights (Lower priority  = Higher importance).
4. **Round Robin (RR)**
   * Cyclic executive algorithm using time slices (Time Quantum) to ensure fair CPU time distribution.

---

## 📊 Features

* **Dynamic Input Processing:** Supports user-defined burst times, priorities, and time quanta via CLI.
* **Gantt Chart Visualization:** Text-based Gantt chart generation for FCFS and preemptive SJF to track CPU states visually.
* **Performance Metrics:** Automatic calculation and tabular display of:
  * Turnaround Time (TAT)
  * Waiting Time (WT)
  * Overall AVWT and AVTAT averages.

---

## 📂 Project Structure

```text
├── FCFS.java                  # FCFS Implementation with Gantt Chart
├── PriorityScheduler.java     # Priority Scheduling Implementation
├── Process.java               # Process Model for Priority Scheduler
├── Main.java                  # Main entry for Priority Scheduler
├── RoundRobinScheduling.java  # Round Robin Implementation
└── SJFTypes.java              # SJF (Preemptive & Non-Preemptive)
