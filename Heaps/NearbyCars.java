import java.util.PriorityQueue;

public class NearbyCars {
    static class InfoCars implements Comparable<InfoCars>{
        String name;
        int x;
        int y;
        public InfoCars(String name, int x, int y){
            this.name = name;
            this.x = x;
            this.y = y;
        }
        int dist = x*x + y*y;
        
        @Override
        public int compareTo(InfoCars ic){
            return this.dist-ic.dist;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<InfoCars> pq = new PriorityQueue<>();
        pq.add(new InfoCars("C0", 3, 3));
        pq.add(new InfoCars("C1", 5, -1));
        pq.add(new InfoCars("C2", -2, 4));
        int k = 2;
        while (k>0){
            System.out.println(pq.peek().name);
            pq.remove();
            k--;
        }
    }
}
