public class MajorityCount {
    public static int specialAlgorithm (int arr[]){
        int ansIndex=0;
        int count=1,i;
        for (i=1;i<arr.length;i++){
            if (arr[i]==arr[ansIndex])
            {
                count++;
            }
            else{
                count--;
            }
            if (count==0){
                ansIndex=i;
                count=1;
            }
        }
        return arr[ansIndex];
    }
    public static int check(int arr[]){
        int val = specialAlgorithm(arr),i,count=0;
        for (i=0;i<arr.length;i++){
            if (arr[i]==val){
                count++;
            }
        }
        if (count>(arr.length/2))
            return val;
        return -1;
    }
    public static void main(String args[]){
        int arr[] = {2,2,1,1,1,2};
        System.out.println(check(arr));
    }
}
