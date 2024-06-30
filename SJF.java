import java.util.*;

class SJN {
    public static void main(String[] args) {
        List<Process> processes = new ArrayList<>();
        
        // Example: Creating some processes with arrival time and burst time
        processes.add(new Process(1, 0, 5));
        processes.add(new Process(2, 1, 3));
        processes.add(new Process(3, 2, 8));
        
        // Sort processes based on burst time
        processes.sort(Comparator.comparing(Process::getBurstTime));
        
        int currentTime = 0;
        
        // Execute processes in SJN/SJF order
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

    public Process(int id, int arrivalTime, int burstTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
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
}
