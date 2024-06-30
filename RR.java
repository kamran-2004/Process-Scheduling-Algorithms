import java.util.*;

class RoundRobin {
    public static void main(String[] args) {
        List<Process> processes = new ArrayList<>();
        
        // Example: Creating some processes with arrival time and burst time
        processes.add(new Process(1, 0, 5));
        processes.add(new Process(2, 1, 3));
        processes.add(new Process(3, 2, 8));
        
        int quantum = 3; // Example quantum size
        
        Queue<Process> queue = new LinkedList<>(processes);
        int currentTime = 0;
        
        // Execute processes in Round Robin order
        while (!queue.isEmpty()) {
            Process current = queue.poll();
            System.out.println("Executing process " + current.getId() + " at time " + currentTime);
            
            if (current.getBurstTime() > quantum) {
                current.setBurstTime(current.getBurstTime() - quantum);
                queue.offer(current);
                currentTime += quantum;
            } else {
                currentTime += current.getBurstTime();
                System.out.println("Process " + current.getId() + " completed at time " + currentTime);
            }
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

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }
}
