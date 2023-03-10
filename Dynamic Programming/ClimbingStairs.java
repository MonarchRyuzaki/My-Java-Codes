import java.util.Arrays;

public class ClimbingStairs {
    public static int countWays(int n){
        if (n == 0){
            return 1;
        }
        if (n < 0){
            return 0;
        }
        return countWays(n-1) + countWays(n-2);
    }

    public static int countWaysMemo(int n, int dp[]){
        if (n == 0){
            return 1;
        }
        if (n < 0){
            return 0;
        }
        if (dp[n] != -1){
            return dp[n];
        }
        dp[n] = countWays(n-1) + countWays(n-2);
        return dp[n];
    }

    public static int countWaysTab(int n){
        int c[] = new int[n+1];
        Arrays.fill(c, -1);
        c[0] = 1;
        for (int i=1; i<=n ;i++){
            if (i == 1){
                c[i] = c[i-1];
            } else {
                c[i] = c[i-1] + c[i-2];
            }
        }
        return c[n];
    }
    public static void main(String[] args) {
        int n=5;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(countWaysTab(5));
    }
}
