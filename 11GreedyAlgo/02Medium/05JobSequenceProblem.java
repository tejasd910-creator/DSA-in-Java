// complex code 

import java.util.*;

class Job {
    char id;
    int deadline;
    int profit;

    Job(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

class JobSequencing {

    public static void main(String[] args) {

        Job[] jobs = {
                new Job('A', 2, 100),
                new Job('B', 1, 19),
                new Job('C', 2, 27),
                new Job('D', 1, 25),
                new Job('E', 3, 15)
        };

        // Sort jobs by profit in descending order
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        // Find maximum deadline
        int maxDeadline = 0;
        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        // Time slots
        char[] slots = new char[maxDeadline + 1];
        Arrays.fill(slots, '-');

        int totalProfit = 0;

        // Schedule jobs
        for (Job job : jobs) {
            for (int j = job.deadline; j > 0; j--) {

                if (slots[j] == '-') {
                    slots[j] = job.id;
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        // Print result
        System.out.print("Scheduled Jobs: ");

        for (int i = 1; i <= maxDeadline; i++) {
            if (slots[i] != '-') {
                System.out.print(slots[i] + " ");
            }
        }

        System.out.println();
        System.out.println("Total Profit = " + totalProfit);
    }
}