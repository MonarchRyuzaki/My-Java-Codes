public class TargetSumSubset {
    public static boolean targetSum(int nums[], int targetSum){
        int n = nums.length;
        boolean dp[][] = new boolean[n+1][targetSum+1];
        for (int i=0; i<dp.length;i++){
            dp[i][0] = true;
        }
        for (int j=1; j<dp[0].length; j++){
            dp[0][j] = false;
        }
        //i -> Items    j -> sum
        for (int i=1; i<dp.length; i++){
            for (int j=1; j<dp[0].length; j++){
                int v = nums[i-1];
                if (v <= j && dp[i-1][j-v]){
                    dp[i][j] = true;
                } else if (dp[i-1][j]){
                    dp[i][j] = true;
                }
            }
        }

        print(dp);
        return dp[n][targetSum];

    }
    public static void print(boolean arr[][]){
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int nums[] = {4, 2, 7, 1, 3};
        int targetSum = 10;
        System.out.println(targetSum(nums, targetSum));
    }
}
