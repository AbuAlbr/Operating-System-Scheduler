# Operating-System-Scheduler
## Overview
This project implements five CPU scheduling algorithms to demonstrate how they work and affect task management. The project is divided into files to keep things simple and easy to read. Each file contains a different scheduling algorithm.

## Algorithms Implemented
### First-Come, First-Served (FCFS):
Processes tasks in the order they arrive.
Simple to implement but can cause delays for short tasks.

### Shortest Job First (Non-Preemptive) (SJFNP):
Runs the task with the shortest execution time first.
Long tasks might wait if many short tasks are queued.\
### Shortest Job First (Preemptive) (SJFP):
Always selects the task with the shortest remaining time.
Complex since it checks tasks constantly for shorter remaining times.

### Priority Scheduling:
Runs tasks based on their priority level.
Lower priority tasks might wait longer.

### Round Robin (RR):
Each task gets a fixed time slice in a circular order.
Works best with a well-chosen time slice to balance fairness and efficiency.


## How to Run
### Clone the repository:
git clone https://github.com/Abdulrahman5843/Project

basg
cd Project

## Key Features
Separate Files: Each algorithm is in its own file for better code management.
Average Time Calculations: Each algorithm calculates average waiting and turnaround times.
Interactive Input: Some algorithms ask for user input for burst time, arrival time, and priority.
## Challenges Faced
Connecting lecture content with programming implementation.
Synchronizing data between arrays.
Difficulty combining individual member codes.
Late project start due to learning curve.
## Conclusion
This project provided insight into different CPU scheduling methods and their impact on performance. Each algorithm has strengths and weaknesses, making it important to select the right one for specific tasks.

## References
W3Schools
GeeksforGeeks
Stack Overflow
Feel free to use or modify this README! Let me know if any further tweaks are needed.
