import java.util.*;

public class Interleave2Q {
    public static void combine(Queue<Integer> q){
        Queue<Integer> first = new LinkedList<>();
        int size = q.size();
        for (int c=1;c<=size/2;c++){
            first.add(q.remove());
        }
        while (!first.isEmpty()){
            q.add(first.remove());
            q.add(q.remove());
        }

        while (!q.isEmpty()){
            System.out.print(q.remove()+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        combine(q);
    }
}