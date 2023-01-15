class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int i,j;
        for (i=n-2;i>=0;i--){
            if (nums[i]<nums[i+1]){
                break;
            }
        }
        if (i<0){
            reverse(nums,0,n-1);
        } else {
            for (j=n-1;j>i;j--)
                if (nums[j]>nums[i]){
                    break;
                }
        }
        swap(nums,i,j);
        reverse(nums,i+1,n-1);
    }
    public static void swap (int arr[] , int si, int ei){
        int temp = arr[si];
        arr[si]=arr[ei];
        arr[ei]=temp;
    }
    public static void reverse (int arr[] , int si , int ei){
        while (si<=ei){
            int temp = arr[si];
            arr[si]=arr[ei];
            arr[ei]=temp;
            si++;
            ei--;
    }
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 6, 5, 4 };
 
        // Function call
        nextPermutation(arr);
 
        // Printing the answer
        for (int i : arr) {
        System.out.print(i + " ");
        }
}