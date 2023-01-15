public class PairSum1 {
    public static boolean findSum(int nums[],int target){
        int lp=0,rp=nums.length-1,sum=0;
        while (lp<rp){
            sum = nums[lp]+nums[rp];
            if (sum<target)
                lp++;
            else    
                rp--;
            if (sum==target){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        System.out.println(findSum(arr, 5));
    }
}
