import java.util.*;

public class MoreThanKSteps {
    static int V = 9;
    static ArrayList<Edge> graph[] = new ArrayList[V];
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
    static class Graph{
        void addEdge(int src, int dest, int wt){
            graph[src].add(new Edge(src, dest, wt));
        }
    }
    public static void createGraph(){

        Graph g = new Graph();
 
        // making above shown graph
        g.addEdge(0, 1, 4);
        g.addEdge(0, 7, 8);
        g.addEdge(1, 2, 8);
        g.addEdge(1, 7, 11);
        g.addEdge(2, 3, 7);
        g.addEdge(2, 8, 2);
        g.addEdge(2, 5, 4);
        g.addEdge(3, 4, 9);
        g.addEdge(3, 5, 14);
        g.addEdge(4, 5, 10);
        g.addEdge(5, 6, 2);
        g.addEdge(6, 7, 1);
        g.addEdge(6, 8, 6);
        g.addEdge(7, 8, 7);
    }
    public static boolean moreThanK(boolean visited[], int k, int curr){
        if (k <= 0){
            return true;
        }
        for (int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if (visited[e.dest] == true){
                continue;
            }
            if (e.wt >= k){
                return true;
            }

            visited[e.dest] = true;

            if (moreThanK(visited, e.wt-k, curr)){
                return true;
            }

            visited[e.dest] = false;
        }
        return false;
    }
    public static void main(String[] args) {
        boolean visited[] = new boolean[V];
        int dist[] = new int[V];
        for (int i=0;i<V;i++){
            graph[i] = new ArrayList<>();
        }
        createGraph();
        System.out.println(moreThanK(visited, 62, 0));
    }
}