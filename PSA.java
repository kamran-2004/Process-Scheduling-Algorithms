import java.util.*;

class PriorityScheduling {
    public static void main(String[] args) {
        List<Process> processes = new ArrayList<>();
        
        // Example: Creating some processes with arrival time, burst time, and priority
        processes.add(new Process(1, 0, 5, 3));
        processes.add(new Process(2, 1, 3, 1));
        processes.add(new Process(3, 2, 8, 2));
        
        // Sort processes based on priority (lower number indicates higher priority)
        processes.sort(Comparator.comparing(Process::getPriority));
        
        int currentTime = 0;
        
        // Execute processes in Priority Scheduling order
        for (Process process : processes) {
            System.out.println("Executing process " + process.getId() + " at time " + currentTime);
            currentTime += process.getBurstTime();
            System.out.println("Process " + process.getId() + " completed at time " + currentTime);
        }
    }
}

class Process {
    private int id;
    private int arrivalTime;
    private int burstTime;
    private int priority;

    public Process(int id, int arrivalTime, int burstTime, int priority) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public int getPriority() {
        return priority;
    }
}
