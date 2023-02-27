import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgoMST {
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
    public static void createGraph(ArrayList<Edge> graph[]){

        for (int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        //0 - vertex;
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        //1 - vertex;
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        //2 - vertex;
        graph[2].add(new Edge(2, 4, 3));

        //3- vertex;
        graph[3].add(new Edge(3, 5, 1));

        
        //4 - vertex;
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

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
    public static void primsAlgo(ArrayList<Edge> graph[]){

        boolean visited[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        int finalCost = 0;

        while (!pq.isEmpty()){
            Pair curr = pq.remove();
            if (!visited[curr.n]){
                visited[curr.n] = true;
                finalCost += curr.cost;

                for (int i=0;i<graph[curr.n].size();i++){
                    Edge e = graph[curr.n].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                }
            }
        }

        System.out.println("The Minimum Spanning Tree Value : "+finalCost);
    }
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];//Initially null rahega

        createGraph(graph);
        primsAlgo(graph);
    }
}