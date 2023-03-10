public class Fibonacci {
    public static int fibo(int n){
        if (n == 0 || n==1){
            return n;
        }
        return fibo(n-1) + fibo(n-2);
    }
    public static int fiboMemo(int n, int dp[]){
        if (n==0 || n==1){
            return n;
        }
        if (dp[n] != 0){
            return dp[n];
        }
        dp[n] = fiboMemo(n-1, dp) + fiboMemo(n-2, dp);
        return dp[n];
    }
    public static int fiboTab(int n){
        int f[] = new int[n+1];
        f[1] = 1;
        for (int i=2; i<=n ;i++){
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }
    public static void main(String[] args) {
        int n = 30;
        //int dp[] = new int[n+1];
        System.out.println(fiboTab(n));
    }
}