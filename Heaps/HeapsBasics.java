import java.util.*;

public class HeapsBasics {
    static class Heap{
        public static ArrayList<Integer> list = new ArrayList<>();

        public static void add(int data){ // O(log n)
            // add at last position
            list.add(data);

            //child and parent
            int x = list.size()-1;//child
            int parent = (x-1)/2;

            while (list.get(x) < list.get(parent)){                        //Sign change for maxHeap
                int temp = list.get(x);
                list.set(x , list.get(parent));
                list.set(parent , temp);

                x = parent;
                parent = (x-1)/2;

            }
        }

        public static int peek(){
            return list.get(0);
        }


        public static void heapify(int i){
            int left = 2*i+1;
            int right = 2*i+2;
            int minIdx = i;

            if (left < list.size() && list.get(left) < list.get(minIdx)){                //2nd Condition me sign change for maxHeap
                minIdx = left;
            }
            if (right < list.size() && list.get(right) < list.get(minIdx)){                //2nd Condition me sign change for maxHeap
                minIdx = right;
            }
            if (minIdx != i){
                //swap the minIdx and i
                int temp = list.get(minIdx);
                list.set(minIdx , list.get(i));
                list.set(i , temp);

                heapify(minIdx);
            }
        }

        public boolean isEmpty(){
            return list.size() == 0;
        }


        public static int remove(){      //O (log n)
            int data = list.get(0);

            //Step 1 - Swap 1st and Last Node
            int temp = list.get(0);
            list.set(0, list.get(list.size()-1));
            list.set(list.size()-1 , temp);


            //Step 2 - Delete the last index of AL
            list.remove(list.size()-1);

            //Step 3 - Heapify : Fixes the Heap
            heapify(0);

            return data;
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b-a));
        pq.add(5);
        pq.add(3);
        pq.add(7);
        pq.add(4);
        pq.add(4);
        while (!pq.isEmpty()) {
            System.out.println(pq.peek());
            pq.remove();
        }
    }
}