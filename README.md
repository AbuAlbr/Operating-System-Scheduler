# Operating System Scheduler - Task Management Redefined

The **Operating System Scheduler** project demonstrates five key CPU scheduling algorithms. It explores how these algorithms manage tasks and affect system performance. This documentation provides an in-depth look at the installation, features, and advanced usage of the scheduler.

---

## Key Features
- **First-Come, First-Served (FCFS):** Tasks are executed in the order they arrive.
- **Shortest Job First (Non-Preemptive) (SJFNP):** Runs the job with the shortest execution time.
- **Shortest Job First (Preemptive) (SJFP):** Selects the task with the shortest remaining time.
- **Priority Scheduling:** Processes tasks based on assigned priority levels.
- **Round Robin (RR):** Assigns a fixed time slice to tasks in a circular order.

---

## Installation Guide

1. **Windows:**
    ```bash
    git clone https://github.com/rayanAdeb/Project
    cd Project
    python run_scheduler.py
    ```

2. **macOS:**
    ```bash
    brew install python3
    git clone https://github.com/rayanAdeb/Project
    cd Project
    python3 run_scheduler.py
    ```

3. **Linux:**
    ```bash
    sudo apt update
    sudo apt install python3
    git clone https://github.com/rayanAdeb/Project
    cd Project
    python3 run_scheduler.py
    ```

---

## User Guide

### Creating a Project
Follow these steps to create and configure a new scheduling project:  
- [ ] Clone the project repository from GitHub.  
- [ ] Choose the algorithm you want to implement.  
- [ ] Write or modify the code for your selected algorithm.  
- [ ] Compile and run the code to test scheduling behavior.  
- [ ] Record and analyze the outputs for insights.

### Collaboration
| **Option**           | **Description**                    | **Tools Used**           |
|----------------------|------------------------------------|--------------------------|
| Shared Projects      | Multiple contributors to the same project | GitHub |
| Task Assignments     | Distribute specific tasks to group members | Google Sheets |
| Communication Tools  | Chat and updates                   | WhatsApp, Discord        |

### Reporting
Users can generate output reports from the scheduling results. Below is an example of a report in JSON format:  
```json
{
  "algorithm": "Round Robin",
  "processes": [
    {"id": 1, "waiting_time": 5, "turnaround_time": 12},
    {"id": 2, "waiting_time": 3, "turnaround_time": 8}
  ],
  "average_waiting_time": 4,
  "average_turnaround_time": 10
}
```
---

## Troubleshooting

- **Process Stuck:**  
  If a process gets stuck, ensure the burst time values are correctly initialized.

- **Incorrect Output:**  
  Verify the scheduling algorithm logic for mistakes in time calculations.

- **Dependencies Issue:**  
  Make sure Python is installed and properly configured on your system.

---

## Advanced Usage

### Scripting
Here’s how to use a script to automate scheduling tests for multiple algorithms:  
```python
algorithms = ["FCFS", "SJFNP", "SJFP", "Priority", "Round Robin"]

for algo in algorithms:
    print(f"Running {algo}...")
    # Execute scheduling logic for each algorithm
```
### Integrations
| **Application**           | **Description**                    | **Link**           |
|----------------------|------------------------------------|--------------------------|
| GitHub         | Repository managements | GitHub              |
| Google Sheets	 | Task tracking	      | Google Sheets      |
| Discord        | Team communication     | WhatsApp, Discord  |
