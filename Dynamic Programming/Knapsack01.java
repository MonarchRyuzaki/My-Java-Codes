import java.util.Arrays;

public class Knapsack01 {
    public static int knapsack01(int val[], int wt[], int W, int n){
        if (n==0 || W == 0){
            return 0;
        }
        if (wt[n-1] <= W){ // Valid
            int ans1 = val[n-1] + knapsack01(val, wt, W-wt[n-1], n-1); // Include 
            int ans2 = knapsack01(val, wt, W, n-1); // Exclude
            return Math.max(ans1, ans2);
        } else { // Not Valid
            return knapsack01(val, wt, W, n-1);
        }
    }
    public static int knapsack01Memo(int val[], int wt[], int W, int n,int dp[][]){
        if (n==0 || W == 0){ 
            return 0;
        }
        if (dp[n][W] != -1){
            return dp[n][W];
        }
        if (wt[n-1] <= W){ // Valid
            int ans1 = val[n-1] + knapsack01Memo(val, wt, W-wt[n-1], n-1, dp); // Include 
            int ans2 = knapsack01Memo(val, wt, W, n-1, dp); // Exclude
            dp[n][W] = Math.max(ans1, ans2);
        } else { // Not Valid
            dp[n][W] = knapsack01Memo(val, wt, W, n-1, dp);
        }
        return dp[n][W];
    }
    public static int knapsack01Tab(int val[], int wt[], int W, int dp[][]){
        int n = val.length;
        for (int i=0; i<dp.length; i++){
            dp[i][0] = 0;
        }
        for (int j=0; j<dp[0].length; j++){
            dp[0][j] = 0;
        }

        for (int i=1; i<dp.length; i++){
            for (int j=1; j<dp[0].length; j++){
                int v = val[i-1];
                int w = wt[i-1];
                if (w <= j){
                    int p1 = v + dp[i-1][j-w];
                    int p2 = dp[i-1][j];
                    dp[i][j] = Math.max(p1,p2);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][W];

    }
    public static void main(String[] args) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7;
        int n = val.length;
        int dp[][] = new int[n+1][W+1];
        for (int i=0; i<dp.length; i++){
            for (int j=0; j< dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(knapsack01Tab(val, wt, W, dp));
    }
}
