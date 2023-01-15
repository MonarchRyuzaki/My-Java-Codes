import java.util.*;

public class StackQueueDeque {
    static class Stack{
        static Deque<Integer> dq = new LinkedList<>();
        public boolean isEmpty(){
            return dq.isEmpty();
        }
        public void push(int data){
            dq.addLast(data);
        }
        public int pop(){
            if (isEmpty()){
                return -1;
            }
            return dq.removeLast();
        }
        public int peek(){
            if (isEmpty()){
                return -1;
            }
            return dq.getLast();
        }
    }
    static class Queue{
        static Deque<Integer> dq = new LinkedList<>();
        public boolean isEmpty(){
            return dq.isEmpty();
        }
        public void add(int data){
            dq.addLast(data);
        }
        public int pop(){
            if (isEmpty()){
                return -1;
            }
            return dq.removeFirst();
        }
        public int peek(){
            if (isEmpty()){
                return -1;
            }
            return dq.getFirst();
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(3);
        q.add(2);
        q.add(1);
        while (!q.isEmpty()){
            System.out.println(q.pop()+" ");
        }
    }
}
