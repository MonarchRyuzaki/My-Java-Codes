import java.util.ArrayList;

public class CycleDetectionUndirected {
    static class Edge{
        int src;
        int dest;
        Edge(int s,int d,int w){
            this.src = s;
            this.dest = d;
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
    public static boolean cycleDetection(ArrayList<Edge> graph[]){

        boolean visited[] = new boolean[graph.length];
        for (int i=0;i<graph.length;i++){
            if (!visited[i]){
                if (cycleDetectionUtil(graph, i, -1, visited)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean cycleDetectionUtil(ArrayList<Edge> graph[], int curr, int par, boolean visited[]){

        visited[curr] = true;

        for (int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if (!visited[curr]){
                if (cycleDetectionUtil(graph, e.dest, curr, visited)){
                    return true;
                }
            } else if (visited[curr] && e.dest!=par){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];//Initially null rahega

        createGraph(graph);
        System.out.println(cycleDetection(graph));
    }
}
