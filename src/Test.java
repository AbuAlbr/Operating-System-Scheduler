package src;

import java.util.*;

public class Test {
  public static void main(String[] args) throws Exception {
    System.out.println("\n\t | Welcome to our scheduling program |");

    int loop = 1;
    while (loop == 1) {
      System.out.println("What do yo Choice"); //

      System.out.println("1. First Come First Served");
      System.out.println("2. Shortest Job First Non-Preemptive");
      System.out.println("3. Shortest Job First Preemptive");
      System.out.println("4. Priority");
      System.out.println("5. Round Robin");

      Scanner scnr = new Scanner(System.in); // Scanner
      int Choice = scnr.nextInt();

      switch (Choice) {
        case 1:
          System.out.println("FCFS");

          System.out.println("First-Come-First Served");

          System.out.print("How many processes do you want? ");
          int processCount = scnr.nextInt();

          int[] burstTime = new int[processCount];
          int[] waitingTime = new int[processCount];
          int[] turnaroundTime = new int[processCount];

          for (int i = 0; i < processCount; i++) {
            System.out.print("Enter burst time for process " + (i + 1) + ": ");
            burstTime[i] = scnr.nextInt();
          }

          // Calculating waiting times
          waitingTime[0] = 0;
          turnaroundTime[0] = burstTime[0];
          for (int i = 1; i < processCount; i++) {
            waitingTime[i] = waitingTime[i - 1] + burstTime[i - 1];
            turnaroundTime[i] = waitingTime[i] + burstTime[i];
          }

          System.out.print("\n" + "process: ");
          for (int i = 0; i < processCount; i++) {
            System.out.print("\t" + (i + 1));
          }

          System.out.print("\n" + "Burst Time: ");
          for (int i = 0; i < processCount; i++) {
            System.out.print("\t" + burstTime[i]); // Output process details
          }

          System.out.print("\n" + "Waiting Time: ");
          for (int i = 0; i < processCount; i++) {
            System.out.print("\t" + waitingTime[i]);
          }

          System.out.print("\n" + "Turnaround Time: ");
          for (int i = 0; i < processCount; i++) {
            System.out.print(turnaroundTime[i] + "\t");
          }

          // Calculate and print average waiting time
          int sumWaitingTime = 0;
          for (int i = 0; i < processCount; i++) {
            sumWaitingTime += waitingTime[i];
          }
          System.out.println("\n" + "Average Waiting Time: " + sumWaitingTime / (double) processCount);

          // Calculate and print average turnaround time
          int sumTurnAroundTime = 0;
          for (int i = 0; i < processCount; i++) {
            sumTurnAroundTime += turnaroundTime[i];
          }
          System.out.println("Average Turnaround Time: " + sumTurnAroundTime / (double) processCount);
          break;
        case 2:
          System.out.println("SJFNP");
          System.out.println("Shortest-Job-First Non-Preemptive");

          System.out.print("How many processes do you want? ");
          int processNumber = scnr.nextInt();

          int[] burstTimes = new int[processNumber];
          int[] arrivalTimes = new int[processNumber];
          int[] waitingTimes = new int[processNumber];
          int[] turnaroundTimes = new int[processNumber];
          boolean[] isCompleted = new boolean[processNumber];

          for (int i = 0; i < processNumber; i++) {
            System.out.print("Enter burst time for process " + (i + 1) + ": ");
            burstTimes[i] = scnr.nextInt();
            System.out.print("Enter arrival time for process " + (i + 1) + ": ");
            arrivalTimes[i] = scnr.nextInt();
          }

          int currentTime = 0;
          int completed = 0;
          while (completed != processNumber) {
            int shortestJobIndex = -1;
            int shortestBurst = Integer.MAX_VALUE;

            for (int i = 0; i < processNumber; i++) {
              if (arrivalTimes[i] <= currentTime && !isCompleted[i] && burstTimes[i] < shortestBurst) {
                shortestBurst = burstTimes[i];
                shortestJobIndex = i;
              }
            }

            if (shortestJobIndex == -1) {
              currentTime++;
            } else {
              waitingTimes[shortestJobIndex] = currentTime - arrivalTimes[shortestJobIndex];
              currentTime += burstTimes[shortestJobIndex];
              turnaroundTimes[shortestJobIndex] = currentTime - arrivalTimes[shortestJobIndex];
              isCompleted[shortestJobIndex] = true;
              completed++;
            }
          }

          System.out.print("\n" + "Process: ");
          for (int i = 0; i < processNumber; i++) {
            System.out.print("\t" + (i + 1));
          }

          System.out.print("\n" + "Arrival Time: ");
          for (int i = 0; i < processNumber; i++) {
            System.out.print("\t" + arrivalTimes[i]);
          }

          System.out.print("\n" + "Burst Time: ");
          for (int i = 0; i < processNumber; i++) {
            System.out.print("\t" + burstTimes[i]); // Output process details
          }

          System.out.print("\n" + "Waiting Time: ");
          for (int i = 0; i < processNumber; i++) {
            System.out.print("\t" + waitingTimes[i]);
          }

          System.out.print("\n" + "Turnaround: ");
          for (int i = 0; i < processNumber; i++) {
            System.out.print("\t" + turnaroundTimes[i]);
          }

          // Calculate and print average waiting time
          int sumsWaitingTime = 0;
          for (int i = 0; i < processNumber; i++) {
            sumsWaitingTime += waitingTimes[i];
          }
          System.out.println("\n" + "Average Waiting Time: " + sumsWaitingTime / (double) processNumber);

          // Calculate and print average turnaround time
          int sumsTurnAroundTime = 0;
          for (int i = 0; i < processNumber; i++) {
            sumsTurnAroundTime += turnaroundTimes[i];
          }
          System.out.println("Average Turnaround Time: " + sumsTurnAroundTime / (double) processNumber);

          break;
        case 3:
          System.out.println("SJF");
          System.out.println("Shortest Job First Preemptive");
          System.out.print("enter the number of process: ");

          int number = scnr.nextInt();

          int process[] = new int[number]; // initialize an array for the processes

          int arrival[] = new int[number]; // initialize an array for the arrival time

          int burst[] = new int[number]; // initialize an array for the burst time

          int check[] = new int[number]; // initialize an array for the processes if it completed or not (flag)

          int tempBurst[] = new int[number]; // initialize an array for the burst time after the update

          int response[] = new int[number]; // initialize an array for the response time

          Arrays.fill(response, -1); // make sure the array is not filled yet

          // ------------------------------------------------------------------------\\

          for (int i = 0; i < number; i++) {
            process[i] = i + 1;

            System.out.print("enter process " + (i + 1) + " arrival time: ");

            arrival[i] = scnr.nextInt(); // inputs

            System.out.print("enter process " + (i + 1) + " burst time: ");

            burst[i] = scnr.nextInt();

            tempBurst[i] = burst[i];

            check[i] = 0;
          }
          // -----------------------------------------------------------------------\\

          int complete[] = new int[number]; // initialize an array for the completion time for the processes

          int timer = 0; // initialize an array for timer (Clock)

          int totalProcces = 0; // initialize an array for completed processes

          // --------------------------------------------------------------------------

          while (true) {
            int min = 99, current = number;

            if (totalProcces == number)
              break;

            for (int i = 0; i < number; i++) {
              if ((arrival[i] <= timer) && (check[i] == 0) && (burst[i] < min)) {
                min = burst[i];
                current = i;
              }
            }

            if (current == number)
              timer++;
            else {

              if (response[current] == -1) {
                response[current] = timer - arrival[current]; // SJF Preemptive scheduling
              }

              burst[current]--;
              timer++;

              if (burst[current] == 0) {
                complete[current] = timer;

                check[current] = 1;

                totalProcces++;
              }
            }
          }

          // ------------------------------------------------------------

          int turnAround[] = new int[number]; // initialize an array for turnaround time

          int waiting[] = new int[number]; // initialize an array for waiting time

          // -----------------------------

          double averageWating = 0;

          double averageTurnAround = 0; // initialize the average

          double averageResponse = 0;

          // -------------------------------------

          for (int i = 0; i < number; i++) {
            turnAround[i] = complete[i] - arrival[i];

            waiting[i] = turnAround[i] - tempBurst[i];

            averageWating += waiting[i]; // calculate the average

            averageTurnAround += turnAround[i];

            averageResponse += response[i];

          }

          // ----------------------------------------------------------------------

          System.out.println();

          System.out.print("process = " + "\t");
          for (int i = 0; i < number; i++) {
            System.out.print("P" + process[i] + "\t");
          }
          System.out.println();

          System.out.print("arrival = " + "\t");
          for (int i = 0; i < number; i++) {
            System.out.print(arrival[i] + "\t");
          }
          System.out.println();

          System.out.print("burst =  " + "\t");
          for (int i = 0; i < number; i++) {
            System.out.print(tempBurst[i] + "\t");
          }
          System.out.println();

          System.out.print("turnAround = " + "\t"); // printing
          for (int i = 0; i < number; i++) {
            System.out.print(turnAround[i] + "\t");
          }
          System.out.println();

          System.out.print("waiting = " + "\t");
          for (int i = 0; i < number; i++) {
            System.out.print(waiting[i] + "\t");
          }
          System.out.println();

          System.out.print("response = " + "\t");
          for (int i = 0; i < number; i++) {
            System.out.print(response[i] + "\t");
          }
          System.out.println();

          System.out.println("\naverage turnaround time is: " + (double) (averageTurnAround / number));

          System.out.println("average waiting time is: " + (double) (averageWating / number));

          System.out.println("average response time is: " + (double) (averageResponse / number));

          // ------------------------------------------------------------------------------------------

          break;

        case 4:
          System.out.println("Priority");

          System.out.print("Enter the number of processes: "); // a number of processes
          int processCounts = scnr.nextInt();

          int[] priorities = new int[processCounts];
          int[] bursts = new int[processCounts]; // creat array for all input
          int[] waitingtimes = new int[processCounts];
          int[] turnaround = new int[processCounts];
          int[] processIds = new int[processCounts];

          // Input priorities and burst times for each process
          for (int i = 0; i < processCounts; i++) {
            processIds[i] = i + 1;
            System.out.print("Enter priority for process " + processIds[i] + ": "); // get input for Priority
            priorities[i] = scnr.nextInt();

            System.out.print("Enter burst time for process " + processIds[i] + ": "); // get input for burst
            bursts[i] = scnr.nextInt();
          }

          // Sort processes by priority (Bubble Sort)
          for (int i = 0; i < processCounts - 1; i++) {
            for (int j = 0; j < processCounts - i - 1; j++) {
              if (priorities[j] > priorities[j + 1]) {
                // Swap priorities
                int tempPriority = priorities[j];
                priorities[j] = priorities[j + 1];
                priorities[j + 1] = tempPriority;

                // Swap bursts
                int tempBursts = bursts[j];
                bursts[j] = bursts[j + 1];
                bursts[j + 1] = tempBursts;

                // Swap process IDs
                int tempProcessId = processIds[j];
                processIds[j] = processIds[j + 1];
                processIds[j + 1] = tempProcessId;
              }
            }
          }

          // Calculate waiting times
          waitingtimes[0] = 0; // Waiting time for the first process is always 0
          for (int i = 1; i < processCounts; i++) {
            waitingtimes[i] = waitingtimes[i - 1] + bursts[i - 1];
          }

          // Calculate turnaround times
          for (int i = 0; i < processCounts; i++) {
            turnaround[i] = waitingtimes[i] + bursts[i];
          }

          System.out.print("\n" + "Priority: ");
          for (int i = 0; i < processCounts; i++) { // first, print Priority
            System.out.print("\t" + priorities[i]);
          }

          System.out.print("\n" + "Process: ");
          for (int i = 0; i < processCounts; i++) {
            System.out.print("\t" + processIds[i]);
          }

          System.out.print("\n" + "Burst Time: ");
          for (int i = 0; i < processCounts; i++) {
            System.out.print("\t" + bursts[i]);
          }

          System.out.print("\n" + "Waiting Time: ");
          for (int i = 0; i < processCounts; i++) {
            System.out.print("\t" + waitingtimes[i]);
          }

          System.out.print("\n" + "Turnaround: ");
          for (int i = 0; i < processCounts; i++) {
            System.out.print("\t" + turnaround[i]);
          }

          // Calculate and print average waiting time
          int sumWaitingTimes = 0;
          for (int i = 0; i < processCounts; i++) {
            sumWaitingTimes += waitingtimes[i];
          }
          System.out.println("\n" + "Average Waiting Time: " + sumWaitingTimes / (double) processCounts);

          // Calculate and print average turnaround time
          int sumTurnAroundTimes = 0;
          for (int i = 0; i < processCounts; i++) {
            sumTurnAroundTimes += turnaround[i];
          }
          System.out.println("Average Turnaround Time: " + sumTurnAroundTimes / (double) processCounts);

          break;

        case 5:
          System.out.println("\n\t| Round Robin Scheduling Algorithm |\n");
          System.out.print("How long time quantum (ms)? ");
          int timeQuantum = scnr.nextInt();

          System.out.print("How many processes do you want? ");
          processCount = scnr.nextInt();

          burstTimes = new int[processCount];
          arrivalTimes = new int[processCount];

          // Option to determine if all processes arrive at the same time (0) or at
          // different times
          System.out.println(
              "\nAre all the processes arrive at the same time 0? (if No, you will enter arrival time for each one)");
          System.out.println("\t\t1.Yes\t2.No");
          int arrive = scnr.nextInt();
          if (arrive == 1) {
            // Input burst time only for each process if all processes arrive at the same time (0)
            for (int i = 0; i < processCount; i++) {
                System.out.print("Enter burst time for process " + (i + 1) + ": ");
                burstTimes[i] = scnr.nextInt();
                arrivalTimes[i] = 0;  // Set arrival time to 0 for each process
            }
        } else {
            // Input burst time and arrival time for each process if they arrive at different times
            for (int i = 0; i < processCount; i++) {
                System.out.print("Enter burst time for process " + (i + 1) + ": ");
                burstTimes[i] = scnr.nextInt();
                System.out.print("Enter arrival time for process " + (i + 1) + ": ");
                arrivalTimes[i] = scnr.nextInt();
            }
        }

          RR rr = new RR(timeQuantum, burstTimes, arrivalTimes);
          rr.printResults();

          break;

      }

      System.out.println("\nDo want another Scheduling? "); // if you want repeat
      System.out.println("\t1.Yes\t2.No");

      loop = scnr.nextInt();

    }

    System.out.println("Thanks for using our program :)");

  }

}
