import java.util.ArrayList;

public class ArticulationPointTarjan{
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
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        //1 - vertex;
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        //2 - vertex;
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        //3- vertex;
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        
        //4 - vertex;
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        //5 - Vertex
        graph[5].add(new Edge(5, 3, 1));        
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        //6 - Vertex
        graph[6].add(new Edge(6, 5 , 1));
    }
    public static void dfs(ArrayList<Edge> graph[], int curr, int par, int time, int low[], int dt[], boolean visited[], boolean ap[]){
        visited[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;
        for (int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            int neigh = e.dest;
            if (neigh == par){
                continue;
            } else if (visited[neigh]){
                low[curr] = Math.min(low[curr],dt[neigh]);
            } else {
                dfs(graph, neigh, curr, time, low, dt, visited, ap);
                low[curr] = Math.min(low[curr],low[neigh]);
                if (par!=-1 && dt[curr]<=low[neigh]){
                    ap[curr] = true;
                }
                children++;
            }
        }

        if (par == -1 && children>1){
            ap[curr] = true;
        }
    } 
    public static void getAP(ArrayList<Edge> graph[], int V){
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean visited[] = new boolean[V];
        boolean ap[] = new boolean[V];
        for (int i=0; i<V;i++){
            if (!visited[i]){
                dfs(graph, i, -1, time, low, dt, visited, ap);
            }
        }

        for (int i=0; i<V; i++){
            if (ap[i]){
                System.out.println("AP : "+i);
            }
        }
    }
    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];//Initially null rahega

        createGraph(graph);
        getAP(graph, V);
    }
}