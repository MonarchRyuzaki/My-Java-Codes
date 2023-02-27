import java.util.PriorityQueue;

public class ConnectNRopes {
    public static void main(String[] args) {
        int arr[] = {1} ;
        int n = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }
        int sum = 0;
        while (pq.size() != 1   ){
            int x = pq.poll();
            int y = pq.poll();
            pq.add(x+y);
            sum = sum + (x+y);
        }
        System.out.println(sum);
    }
}
