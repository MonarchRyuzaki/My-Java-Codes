public class LexSmallestArrayafterKconsSwaps {
    public static void findSmallest(int arr[] , int n , int k){
        
        for (int i=0;i<n-1 && k>0 ; i++){

            int pos = i;
            for (int j=i+1 ; j<n;j++){
                //Max swaps exceeds k Swaps
                if (j-i > k){
                    break;
                }

                if (arr[j] < arr[pos]){
                    pos = j;
                }
            }


            for (int j=pos ; j>i;j--){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }

            k -= pos-i;
        }
    }
    public static void main(String[] args) {
        int arr[] = {7,6,9,2,1};
        int k = 3;
        int n = arr.length;
        findSmallest(arr, n, k);

        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
}