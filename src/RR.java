package src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RR {
    private int timeQuantum;
    private int[] burstTime;
    private int[] arrivalTime;
    private int[] waitingTime;
    private int[] turnaroundTime;
    private int[] responseTime;
    private ArrayList<Integer> executionOrder;

    public RR(int timeQuantum, int[] burstTime, int[] arrivalTime) {
        this.timeQuantum = timeQuantum;
        this.burstTime = burstTime;
        this.arrivalTime = arrivalTime;
        int numOfProcesses = burstTime.length; // it's equal to number of processes
        this.waitingTime = new int[numOfProcesses];
        this.turnaroundTime = new int[numOfProcesses];
        this.responseTime = new int[numOfProcesses];
        this.executionOrder = new ArrayList<>();
        applyAlgorithm();
    }

    private void applyAlgorithm() {
        int numOfProcesses = burstTime.length;
        int[] remainingBurstTime = new int[numOfProcesses];
        boolean[] isFirstResponse = new boolean[numOfProcesses]; // Track if it's the first response for each process
        for (int i = 0; i < numOfProcesses; i++) {
            remainingBurstTime[i] = burstTime[i];
            isFirstResponse[i] = true;
        }

        int currentTime = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0); // Start with the first process
        boolean[] isInQueue = new boolean[numOfProcesses];
        isInQueue[0] = true;

        while (!queue.isEmpty()) {
            int processIndex = queue.poll(); // Get the index of the process to be executed next from the queue
            if (isFirstResponse[processIndex]) { // Check if it's the first response of the process
                responseTime[processIndex] = currentTime - arrivalTime[processIndex];
                isFirstResponse[processIndex] = false;
            }

            // Execute the process for a time quantum or until completion
            if (remainingBurstTime[processIndex] > timeQuantum) { // If remaining burst time is greater than time quantum, execute for a time quantum
                currentTime += timeQuantum;
                remainingBurstTime[processIndex] -= timeQuantum;
                // Add the process to execution order list
                executionOrder.add(processIndex + 1); // +1 for 1-based process numbering
            } else { // If remaining burst time is less than or equal to time quantum, execute until completion
                currentTime += remainingBurstTime[processIndex];
                waitingTime[processIndex] = currentTime - burstTime[processIndex] - arrivalTime[processIndex];
                remainingBurstTime[processIndex] = 0; // Set remaining burst time of the process to 0 (process finishes)
                executionOrder.add(processIndex + 1); 
            }

            // Check for new processes arriving during the execution
            for (int i = 1; i < numOfProcesses; i++) {
                if (arrivalTime[i] <= currentTime && remainingBurstTime[i] > 0 && !isInQueue[i]) {
                    // If process has arrived, has remaining burst time, and not in queue
                    // Add process to queue
                    queue.add(i);
                    isInQueue[i] = true; // Mark process as in queue
                }
            }
            if (remainingBurstTime[processIndex] > 0) { 
                // Re-add the process to the queue if it's not finished
                queue.add(processIndex);
            }
        }

        // Calculate turnaround time for each process
        for (int i = 0; i < numOfProcesses; i++) {
            turnaroundTime[i] = burstTime[i] + waitingTime[i];
        }
    }

    public void printResults() {
        System.out.print("\n" + "Process:\t");
        for (int i = 0; i < burstTime.length; i++) {
            System.out.print("\tP" + (i + 1));
        }

        System.out.print("\n" + "Burst Time:\t");
        for (int i = 0; i < burstTime.length; i++) {
            System.out.print("\t" + burstTime[i]);
        }

        System.out.print("\n" + "Arrival Time:\t");
        for (int i = 0; i < burstTime.length; i++) {
            System.out.print("\t" + arrivalTime[i]);
        }

        System.out.print("\n" + "Waiting Time:\t");
        for (int i = 0; i < burstTime.length; i++) {
            System.out.print("\t" + waitingTime[i]);
        }

        System.out.print("\n" + "Turnaround Time:");
        for (int i = 0; i < burstTime.length; i++) {
            System.out.print("\t" + turnaroundTime[i]);
        }

        System.out.print("\n" + "Response Time:\t");
        for (int i = 0; i < burstTime.length; i++) {
            System.out.print("\t" + responseTime[i]);
        }

        // Calculate and print average waiting time, turnaround time, and response time
        double sumWaitingTimes = 0;
        for (int i = 0; i < burstTime.length; i++) {
            sumWaitingTimes += waitingTime[i];
        }

        double sumTurnAroundTime = 0;
        for (int i = 0; i < burstTime.length; i++) {
            sumTurnAroundTime += turnaroundTime[i];
        }

        double sumResponseTime = 0;
        for (int i = 0; i < burstTime.length; i++) {
            sumResponseTime += responseTime[i];
        }

        System.out.printf("%n%naverage waiting time is: %.3f%n", (sumWaitingTimes / burstTime.length));
        System.out.printf("average turnaround time is: %.3f%n", (sumTurnAroundTime / burstTime.length));
        System.out.printf("average response time is: %.3f%n", (sumResponseTime / burstTime.length));
        
        // Print the execution order of processes
        System.out.println("\nExecution Order: " + executionOrder);

    }

}
