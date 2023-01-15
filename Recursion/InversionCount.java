public class InversionCount {
    public static int count(int arr[]){
        int i,j,count=0;
        for (i=0;i<arr.length;i++){
            for (j=0;j<arr.length;j++){
                if (arr[i]<arr[j] && i>j){
                    count++;
                }
            }
        }
        return count;
    }
    public static void  main (String args[]){
        int arr[] = {2, 4, 1, 3, 5};
        System.out.println("Inversion Count :"+count(arr));
    }
}
