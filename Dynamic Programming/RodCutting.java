public class RodCutting {
    public static int rodCutting(int l[], int price[], int rodLength){
        int n = price.length;
        int dp[][] = new int[n+1][rodLength+1];
        for (int i=0; i<dp.length; i++){
            dp[i][0] = 0;
        }
        for (int j=0; j<dp[0].length; j++){
            dp[0][j] = 0;
        }

        for (int i=1; i<dp.length; i++){
            for (int j=1; j<dp[0].length; j++){
                int v = price[i-1];
                int len = l[i-1];
                if (len <= j){
                    dp[i][j] = Math.max(v + dp[i][j-len], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        print(dp);
        return dp[n][rodLength];
    }

    public static void print(int arr[][]){
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int length[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
        int rodLength = 8;
        System.out.println(rodCutting(length, price, rodLength));
    }
}
