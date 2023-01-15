import java.util.PriorityQueue;

public class SlindingWindowMaximum {
    static class pair implements Comparable<pair>{
        int val;
        int idx;
        pair(int val , int idx){
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(pair p2){
            return p2.val - this.val;            //Descending Order / max Heap
        }
    }

    public static void main(String[] args) {
        
        int arr[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int ans[] = new int[arr.length-k+1];
        PriorityQueue<pair> pq = new PriorityQueue<>();
        int i = 0;

        //1st window 
        for (i = 0 ;i<k;i++){
            pq.add(new pair(arr[i], i));
        }
        ans[0] = pq.peek().val;

        //Sliding Window
        for (i=k;i<arr.length;i++){
            while (pq.size()>0 && pq.peek().idx <= (i-k)){
                pq.remove();
            }
            pq.add(new pair(arr[i], i));
            ans[i-k+1]=pq.peek().val;
        }

        //Print Array
        for (int j = 0 ; j < ans.length ; j++){
            System.out.print(ans[j]+" ");
        }
    }
}