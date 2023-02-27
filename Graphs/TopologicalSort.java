import java.util.*;

public class TopologicalSort {
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

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4 , 0));
        graph[4].add(new Edge(4 , 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
        
    }
    public static void topSortDFS(ArrayList<Edge> graph[]){//O(V+E)

        boolean visited[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for (int i=0;i<graph.length;i++){
            if (!visited[i]){
                topSortDFSUtil(graph,visited,s,i);
            }
        }

        //The Sorted order
        while (!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
    }
    public static void topSortDFSUtil(ArrayList<Edge> graph[], boolean visited[], Stack<Integer> s, int curr){
        visited[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]){
                topSortDFSUtil(graph, visited, s, e.dest);
            }
        }
        s.push(curr);
    }
    public static void calcIndegree(ArrayList<Edge> graph[],int indeg[]){
        
        for (int i=0;i<graph.length;i++){
            int v = i;
            for (int j=0;j<graph[v].size();j++){
                Edge e = graph[v].get(j);
                indeg[e.dest]++;
            }
        }
    }
    public static void topSortBFS(ArrayList<Edge> graph[]){     //Kahn's Algorithm
        int indeg[] = new int[graph.length];
        calcIndegree(graph, indeg);
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0;i<indeg.length;i++){
            if (indeg[i]==0){
                q.add(i);
            }
        }

        while (!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr+" ");
            for (int i = 0; i<graph[curr].size();i++){
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if (indeg[e.dest] == 0){
                    q.add(e.dest);
                }
            }
        }

    }
    public static void main(String[] args) {
        
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];//Initially null rahega

        createGraph(graph);
        topSortDFS(graph);
        System.out.println();
        topSortBFS(graph);
    }
}