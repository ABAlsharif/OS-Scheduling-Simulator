# CPU Scheduling Algorithms Simulator

A comprehensive Java-based simulator that implements various Central Processing Unit (CPU) scheduling algorithms. This project demonstrates core Operating Systems (OS) concepts, including process management, scheduling criteria, and performance evaluation metrics like Average Waiting Time (AWT) and Average Turnaround Time (ATAT).

## 🚀 Implemented Algorithms

1. **Shortest Job First (SJF)**
   * **Non-Preemptive:** Selects the process with the shortest burst time execution.
   * **Preemptive (SRTF - Shortest Remaining Time First):** Interrupts the current process if a new process arrives with a shorter remaining burst time. Includes a dynamic **Gantt Chart** generator.
2. **Priority Scheduling (Non-Preemptive)**
   * Schedules processes based on priority weights (Lower priority number = Higher importance).
3. **Round Robin (RR)**
   * Cyclic executive algorithm using time slices (Time Quantum) to ensure fair CPU time distribution.

---

## 📊 Features

* **Dynamic Input Processing:** Supports user-defined arrival times, burst times, priorities, and time quanta via CLI.
* **Gantt Chart Visualization:** Text-based Gantt chart generation for preemptive SJF to track CPU states and Idle times visually.
* **Performance Metrics:** Automatic calculation and tabular display of:
  * Turnaround Time (TAT)
  * Waiting Time (WT)
  * Completion Time (CT)
  * Overall AWT and ATAT averages.

---

## 📂 Project Structure

```text
├── src/
│   ├── Main.java                  # Main entry point (Interactive Menu)
│   ├── Process.java               # Unified Process Model
│   ├── PriorityScheduler.java     # Priority Scheduling Implementation
│   ├── RoundRobinScheduling.java  # Round Robin Implementation
│   └── SJFTypes.java              # SJF (Preemptive & Non-Preemptive)
└── README.md
