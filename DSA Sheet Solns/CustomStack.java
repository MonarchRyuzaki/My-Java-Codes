import java.util.*;

public class CustomStack {
    static class ModStack{
        static Deque<Integer> dq = new LinkedList<>();
        public static boolean isEmpty(){
            return dq.isEmpty();
        }
        public static void push(int data){
            dq.addFirst(data);
        }
        public static int pop(){
            if (isEmpty()){
                return -1;
            }
            return dq.removeFirst();
        }
        public static int popMiddle(){
            int size = dq.size();
            int count=0;
            Queue<Integer> q = new LinkedList<>();
            while (count<(size/2)){
                q.add(dq.removeFirst());
                count++;
            }
            int x = dq.removeFirst();
            while (!dq.isEmpty()){
                q.add(dq.removeFirst());
            }
            while (!q.isEmpty()){
                dq.add(q.remove());
            }
            return x;
        }
        public static int peekMiddle(){
            int size = dq.size();
            int count=0;
            Queue<Integer> q = new LinkedList<>();
            while (count<(size/2)){
                q.add(dq.removeFirst());
                count++;
            }
            int x = dq.peekFirst();
            while (!dq.isEmpty()){
                q.add(dq.removeFirst());
            }
            while (!q.isEmpty()){
                dq.add(q.remove());
            }
            return x;
        }
    }
    public static void main(String[] args) {
        ModStack s = new ModStack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        System.out.println(s.popMiddle());
        while (!s.isEmpty()){
            System.out.println(s.pop()+" ");
        }
    }
}
