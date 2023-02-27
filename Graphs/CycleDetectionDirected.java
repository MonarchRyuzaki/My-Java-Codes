import java.util.ArrayList;

public class CycleDetectionDirected {
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

        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 0));
        
    }

    public static boolean isCycle(ArrayList<Edge> graph[]){
        
        boolean visited[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for (int i=0; i<graph.length;i++){
            if (!visited[i]){
                if (isCycleUtil(graph,visited,stack,i)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isCycleUtil(ArrayList<Edge> graph[], boolean visited[], boolean stack[], int curr){
        visited[curr] = true;
        stack[curr]=true;

        for (int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if (stack[e.dest]){
                return true;
            } else if (!visited[e.dest] && isCycleUtil(graph, visited, stack, e.dest)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];//Initially null rahega

        createGraph(graph);
        System.out.println(isCycle(graph));
    }
}