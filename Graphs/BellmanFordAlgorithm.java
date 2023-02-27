import java.util.ArrayList;

public class BellmanFordAlgorithm {
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
        graph[1].add(new Edge(1, 2, -4));

        //2 - vertex;
        graph[2].add(new Edge(2, 3, 2));

        //3- vertex;
        graph[3].add(new Edge(3, 4, 4));

        
        //4 - vertex;
        graph[4].add(new Edge(4, 1, -1));
    }
    public static void bellmanFordAlgo(ArrayList<Edge> graph[] , int src){
        int V = graph.length;
        int dist[] = new int[V];
        for (int i=0;i<graph.length;i++){
            if (src != i){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        for (int i=0;i<V-1;i++){ //O(V)
            //Edges - O(E)
            for (int j=0;j<graph.length;j++){
                for (int k = 0; k<graph[j].size();k++){
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                        dist[v] = dist[u]+wt;
                    }
                }
            }
        }

        //Printing the distances
        for (int i=0;i<dist.length;i++){
            System.out.print(dist[i]+" ");
        }
    }
    public static void createGraphAlt(ArrayList<Edge> graph){
        //0 - vertex;
        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 4));
    
        //1 - vertex;
        graph.add(new Edge(1, 2, -4));
    
        //2 - vertex;
        graph.add(new Edge(2, 3, 2));
    
        //3- vertex;
        graph.add(new Edge(3, 4, 4));
    
        //4 - vertex;
        graph.add(new Edge(4, 1, -1));
    }
    public static void bellmanFordAlgoAlt(ArrayList<Edge> graph , int src, int V){
        int dist[] = new int[V];
        for (int i=0;i<V;i++){
            if (src != i){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        for (int i=0;i<V-1;i++){ //O(V)
            //Edges - O(E)
            for (int j=0;j<graph.size();j++){
                Edge e = graph.get(j);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                    dist[v] = dist[u]+wt;
                }
            }
        }
        //Printing the distances
        for (int i=0;i<dist.length;i++){
           System.out.print(dist[i]+" ");
        }
    }
    public static void main(String[] args) {
        int V = 5;
        // ArrayList<Edge> graph[] = new ArrayList[V];//Initially null rahega

        // createGraph(graph);
        // bellmanFordAlgo(graph, 0);

        ArrayList<Edge> graph = new ArrayList<>();
        createGraphAlt(graph);
        bellmanFordAlgoAlt(graph, 0,V);
    }
}