import java.util.*;

public class MinTimetoFillNSlots{
    static int time = 0;

    public static void findMinTime(int N , int arr[]){
        Queue<Integer> q = new LinkedList<>();
        boolean visit[] = new boolean[N+1] ;
        for (int i = 0; i < arr.length; i++) {
 
            q.add(arr[i]);
            visit[arr[i]] = true;
        }

        while (!q.isEmpty()){

            for (int i=0;i<q.size();i++){
                int curr = q.poll();
                if (curr - 1 >= 1 && !visit[curr - 1]) {
                    visit[curr - 1] = true;
                    q.add(curr - 1);
                }
 
                // If next slot is present
                // and not visited
                if (curr + 1 <= N && !visit[curr + 1]) {
                    visit[curr + 1] = true;
                    q.add(curr + 1);
                }
            }

            time++;
        }
    }
    public static void main(String[] args) {
        int N = 6;
        int arr[] = {2, 6};
        findMinTime(N, arr);
        System.out.println("The minimum time required is : "+ (time-1));
    }
}