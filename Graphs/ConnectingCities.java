import java.util.ArrayList;
import java.util.PriorityQueue;

public class ConnectingCities {
    static class Edge{
        int src;
        int dest;
        int wt;
        Edge(int s,int d,int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    static class Pair implements Comparable<Pair>{
        int n;
        int cost;
        Pair(int n, int cost){
            this.n = n;
            this.cost = cost;
        }
        @Override
        public int compareTo(Pair o) {
            return this.cost-o.cost;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[], int cities[][], int n){

        for (int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }

        for (int i=0;i<n;i++){
            for (int j =0 ;j<n;j++){
                if (cities[i][j] != 0){
                    graph[i].add(new Edge(i, j, cities[i][j]));
                }
            }
        }
        
    }
    public static int connectCities(int cities[][], int n){

        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(graph,cities,n);

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int finalCost = 0;
        boolean visited[] = new boolean[n];
        pq.add(new Pair(0, 0));
        while (!pq.isEmpty()){
            Pair curr = pq.remove();
            if (!visited[curr.n]){
                visited[curr.n] = true;
                finalCost += curr.cost;
                for (int i=0; i<graph[curr.n].size();i++){
                    Edge e = graph[curr.n].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                }
            }
        }
        return finalCost;
    }
    public static void main(String[] args) {
        
        int n = 5;
        int cities[][] = {{0,1,2,3,4} , {1,0,5,0,7} , {2,5,0,6,0} , {3,0,6,0,0} , {4,7,0,0,0}};

        System.out.println(connectCities(cities, n));
    }
}
