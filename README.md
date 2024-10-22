# Operating System Scheduler - CPU Scheduling Algorithms Redefined

 Operating System Scheduler is a tool designed to implement and compare different CPU scheduling algorithms. This project helps understand how various algorithms manage tasks and affect system performance, aiding developers and computer scientists in selecting the most suitable algorithm for their needs.

---

## Key Features

- **First-Come, First-Served (FCFS)**: Processes tasks in the order they arrive, with no preemption. :alarm_clock:
- **Shortest-Job-First (Non-Preemptive) (SJFNP)**: Selects the task with the shortest execution time and runs it until it completes. :straight_ruler:
- **Shortest-Job-First (Preemptive) (SJFP)**: Always picks the task with the shortest remaining time and allows task switching. :arrows_counterclockwise:
- **Priority Scheduling**: Processes tasks based on their priority, giving higher priority tasks precedence. :star:
- **Round Robin (RR)**: Allocates a fixed time slice to each task, distributing CPU time fairly in a circular order. :arrows_counterclockwise:

---

## Installation Guide

Follow these steps to install the Operating System Scheduler on various platforms:

1. **Windows**
    ```bash
    git clone https://github.com/Abdulrahman5843/Operating-System-Scheduler
    cd Project
    ./install_windows.bat
    ```

2. **macOS**
    ```bash
    git clone https://github.com/Abdulrahman5843/Operating-System-Scheduler
    cd Project
    ./install_mac.sh
    ```

3. **Linux**
    ```bash
    git clone https://github.com/Abdulrahman5843/Operating-System-Scheduler
    cd Project
    sudo ./install_linux.sh
    ```

---

## User Guide

### Creating a Project
To create a new project in the Operating System Scheduler, follow these steps:

- [ ] Name the project
- [ ] Select the scheduling algorithm
- [ ] Define the number of processes
- [ ] Input process data (arrival time, burst time, etc.)
- [ ] Run the algorithm

### Collaboration

| Collaboration Option   | Description                                           | Availability |
|------------------------|-------------------------------------------------------|--------------|
| **Shared Projects**     | Share scheduling results with other users             | Available    |
| **Task Assignments**    | Assign CPU tasks to team members                      | Available    |
| **Communication Tools** | Collaborate via built-in messaging or external tools  | Coming soon  |

### Reporting

Users can generate reports showing the results of different scheduling algorithms. Below is an example of a JSON-formatted report:

```json
{
  "algorithm": "FCFS",
  "processes": [
    {"id": 1, "burst_time": 10, "waiting_time": 0, "turnaround_time": 10},
    {"id": 2, "burst_time": 5, "waiting_time": 10, "turnaround_time": 15}
  ],
  "average_waiting_time": 5,
  "average_turnaround_time": 12.5
}
```

## Troubleshooting

- **Process not starting**:  
  Ensure that all required process details (e.g., burst time, arrival time) are correctly entered before starting the scheduling algorithm.

- **Incorrect scheduling order**:  
  Double-check that the selected scheduling algorithm is appropriate for the task (e.g., FCFS for first-come-first-served order, SJF for shortest job first).

- **Report generation fails**:  
  Make sure all processes are complete and the algorithm has been run successfully before generating reports.

---

## Advanced Usage

### Scripting

In Operating System Scheduler, you can automate tasks by writing scripts. Below is an example of a Python script that runs the FCFS scheduling algorithm:

```python
processes = [
    {"id": 1, "burst_time": 10, "arrival_time": 0},
    {"id": 2, "burst_time": 5, "arrival_time": 2}
]

scheduler = Scheduler()
scheduler.run_fcfs(processes)

```

### Integrations

Operating System Scheduler can integrate with a variety of tools to enhance its functionality. Below is a table showing some of the supported integrations:

| **Application Name**   | **Description**                             | **Link**                             |
|------------------------|---------------------------------------------|--------------------------------------|
| **Slack**              | Receive notifications for process completions | [Slack](https://slack.com)           |
| **Jira**               | Track scheduling tasks using Jira issues     | [Jira](https://jira.com)             |
| **GitHub**             | Automate project management with GitHub Issues | [GitHub](https://github.com)         |
| **Trello**             | Organize tasks and processes in a visual format | [Trello](https://trello.com)         |
| **Asana**              | Track scheduling tasks as project milestones | [Asana](https://asana.com)           |

---

## Footnotes

1. For more information on different CPU scheduling algorithms, you can refer to [GeeksForGeeks](https://www.geeksforgeeks.org/cpu-scheduling-in-operating-systems/).  
2. Learn more about process scheduling in operating systems from [W3Schools](https://www.w3schools.com/os/os_processes.asp).

---

