import java.util.*;

public class Main {

    public static int solution(int[] p, int[] w, int n, int K ) {
        // Base case
        if (n == 0 || K == 0)
            return 0;
      // If weight of the nth item is more than the capacity, exclude it
        if(w[n - 1] > K) {
           return solution(p, w, n - 1, K);
        } else {
            // Include the nth item or exclude it, whichever gives the maximum profit
            return Math.max(
                p[n - 1] + solution(p, w, n - 1, K - w[n - 1]),
                solution(p, w, n - 1, K)
            );
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // Input the number of items
        int n = s.nextInt();
        int[] p = new int[n]; // Profits array
        int[] w = new int[n]; // Weights array

        // Input profits and weights
        for (int i = 0; i < n; i++) {
            p[i] = s.nextInt();
            w[i] = s.nextInt();
        }

        // Input the capacity of the knapsack
        int K = s.nextInt();
        // Calculate the maximum profit
        int maxProfit = solution(p, w, n, K);

        // Output the result
        System.out.print("Profit is: " + maxProfit);

    }
}

