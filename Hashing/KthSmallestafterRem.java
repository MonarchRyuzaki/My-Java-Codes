import java.util.Arrays;
import java.util.PriorityQueue;

public class KthSmallestafterRem{
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 7, 8, 9};
        Arrays.sort(arr);
        int k = 4;
        int l = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=1;i<=arr.length+k;i++){
            if (l<arr.length && i == arr[l]){
                l++;
            } else {
                pq.add(i);
            }
        }
        System.out.println(pq);
        while (pq.size() != 1){
            pq.poll();
        }
        System.out.println(pq.peek());
    }
}