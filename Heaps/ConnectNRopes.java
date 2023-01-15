import java.util.PriorityQueue;

public class ConnectNRopes {
    public static void main(String[] args) {

        int ropes[] = {4 , 3 , 2 , 6};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //adding values to PQ
        for (int i=0 ; i<ropes.length ; i++){
            pq.add(ropes[i]);
        }
        int ans = 0;
        while (pq.size() > 1){
            int a = pq.remove();
            int b = pq.remove();
            ans = ans + a + b;
            pq.add(a+b);
        }
        System.out.println(ans);
    }
}
