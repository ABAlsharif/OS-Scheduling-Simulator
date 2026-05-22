public class Process {
    String name;
    int burstTime;
    int priority;
    int waitingTime;
    int turnaroundTime;

    public Process(String name, int burstTime, int priority) {
        this.name = name;
        this.burstTime = burstTime;
        this.priority = priority;
    }
}
