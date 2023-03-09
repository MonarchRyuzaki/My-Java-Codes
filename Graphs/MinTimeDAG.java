import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MinTimeDAG {
    static class Edge{
        int src;
        int dest;
        Edge(int s,int d){
            this.src = s;
            this.dest = d;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){

        for (int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));
        graph[1].add(new Edge(1, 4));
        graph[2].add(new Edge(2, 5));
        graph[3].add(new Edge(3, 5));
        graph[4].add(new Edge(4, 6));
        
    }
    public static void findIndeg(ArrayList<Edge> graph[], int indeg[]){

        for (int i=0; i<graph.length;i++){
            for (int j=0;j<graph[i].size();j++){
                Edge e = graph[i].get(j);
                indeg[e.dest]++;
            }
        }
    }
    public static void findMinTime(ArrayList<Edge> graph[], int V,int dist[]){
        int indeg[] = new int[V];
        findIndeg(graph, indeg);
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<indeg.length; i++){
            if (indeg[i] == 0){
                q.add(i);
                dist[i] = 1;
            }
        }
        while (!q.isEmpty()){
            int curr = q.remove();
            for (int i=0; i<graph[curr].size();i++){
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if (indeg[e.dest] == 0){
                    q.add(i);
                    dist[e.dest] = dist[curr] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];//Initially null rahega
        int dist[] = new int[V];
        createGraph(graph);
        findMinTime(graph, V, dist);
        for (int i=0 ;i<V;i++){
            System.out.print(dist[i]+" ");
        }
    }
}