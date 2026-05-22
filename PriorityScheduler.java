import java.util.*;

public class PriorityScheduler {
    public void schedule(List<Process> processes) {
        // ترتيب العمليات حسب الأولوية (الأولوية الأقل = أهم)
        processes.sort(Comparator.comparingInt(p -> p.priority));

        int currentTime = 0;
        int totalWaiting = 0;
        int totalTurnaround = 0;

        // رأس الجدول
        System.out.printf("%-8s %-8s %-10s %-8s %-8s\n", "Process", "BT", "PRIORITY", "WT", "TAT");

        for (Process p : processes) {
            p.waitingTime = currentTime;
            p.turnaroundTime = p.waitingTime + p.burstTime;
            currentTime += p.burstTime;

            totalWaiting += p.waitingTime;
            totalTurnaround += p.turnaroundTime;

            // طباعة البيانات بتنسيق مرتب
            System.out.printf("%-8s %-8d %-10d %-8d %-8d\n",
                    p.name, p.burstTime, p.priority, p.waitingTime, p.turnaroundTime);
        }

        // المتوسطات
        System.out.println("\nAverage Waiting Time: " + (float) totalWaiting / processes.size());
        System.out.println("Average Turnaround Time: " + (float) totalTurnaround / processes.size());
    }
}