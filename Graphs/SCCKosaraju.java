import java.util.ArrayList;
import java.util.Stack;

public class SCCKosaraju {
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
        graph[0].add(new Edge(0, 2, 1));
        graph[0].add(new Edge(0, 3, 1));

        //1 - vertex;
        graph[1].add(new Edge(1, 0, 1));

        //2 - vertex;
        graph[2].add(new Edge(2, 1, 1));

        //3- vertex;
        graph[3].add(new Edge(3, 4, 1));
        
    }
    public static void topSort(ArrayList<Edge> graph[], boolean visited[], int curr, Stack<Integer> s){
        visited[curr] = true;
        for (int i = 0 ;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]){
                topSort(graph, visited, e.dest, s);
            }
        }
        s.push(curr);
    }
    public static void dfs(ArrayList<Edge> graph[], boolean vis[], int curr){
        System.out.print(curr+" ");
        vis[curr] = true;
        for (int i=0 ; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]){
                dfs(graph, vis, e.dest);
            }
        }
    }
    public static void sccKosraju(ArrayList<Edge> graph[],int V){
        boolean visited[] = new boolean[V];
        Stack<Integer> s = new Stack<>();
        //Step - 1
        //TopSort
        for (int i=0; i<V; i++){
            if (!visited[i]){
                topSort(graph, visited, i, s);
            }
        }
        //Step - 2
        //Create the transpose of the graph
        ArrayList<Edge> transpose[] = new ArrayList[V];
        for (int i=0;i<transpose.length;i++){
            visited[i] = false;
            transpose[i] = new ArrayList<>();
        }
        for (int i=0; i<V;i++){
            for (int j=0; j<graph[i].size();j++){
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest, e.src, e.wt));
            }
        }
        //Step - 3
        //Do Dfs on the transpose
        while (!s.isEmpty()){
            int curr = s.pop();
            if (!visited[curr]){
                System.out.print("SCC ->");
                dfs(transpose, visited, curr);
                System.out.println();;
            }
        }
    }
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        sccKosraju(graph, V);
    }
}