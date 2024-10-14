package Java;

import java.util.PriorityQueue;

class Job {
  String name;
  int length;
  int priority;

  public Job(String name, int length, int priority) {
    this.name = name;
    this.length = length;
    this.priority = priority;
  }
}

public class CPUJobScheduler {
  public static void main(String[] args) {
    PriorityQueue<Job> jobQueue = new PriorityQueue<>((j1, j2) -> j2.priority - j1.priority);
    int timeSlice = 0;

    while (timeSlice < 10) { // Simulate 10 time slices
      // Process commands or add new jobs
      // For simplicity, commands are hardcoded here
      if (timeSlice == 0) {
        jobQueue.add(new Job("Job1", 3, 5));
        jobQueue.add(new Job("Job2", 2, 10));
      }

      // Check if there are jobs to run
      if (!jobQueue.isEmpty()) {
        Job currentJob = jobQueue.poll();
        System.out.println("Time Slice " + timeSlice + ": Running job " + currentJob.name);

        // Simulate the job running for its length
        for (int i = 0; i < currentJob.length; i++) {
          System.out.println("Time Slice " + timeSlice + ": Running job " + currentJob.name);
        }
      } else {
        System.out.println("Time Slice " + timeSlice + ": No new job this slice");
      }

      timeSlice++;
    }
  }
}