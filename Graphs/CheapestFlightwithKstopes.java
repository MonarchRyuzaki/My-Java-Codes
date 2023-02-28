import java.util.*;

public class CheapestFlightwithKstopes {
    static class Edge{
        int st;
        int end;
        int price;
        Edge(int a,int b, int c){
            this.st = a;
            this.end = b;
            this.price = c;
        }
    }
    static class Info{
        int v;
        int cost;
        int stops;
        Info(int a,int b,int c){
            this.v = a;
            this.cost = b;
            this.stops = c;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[],int flights[][]){

        for (int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<flights.length;i++){
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];
            Edge e = new Edge(src, dest, wt);
            graph[src].add(e);
        }
    }

    public static int cheapFlight(int flights[][], int src, int dest, int k,int n){
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(graph, flights);

        int dist[] = new int[graph.length];
        for (int i=0;i<dist.length;i++){
            if (i!=src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src,0,0));
        while (!q.isEmpty()){
            Info curr = q.remove();
            if (curr.stops > k){
                break;
            }

            for (int i=0;i<graph[curr.v].size();i++){
                Edge e = graph[curr.v].get(i);
                int u = e.st;
                int v = e.end;
                int wt = e.price;
                if (curr.cost+wt<dist[v] && curr.stops<=k){
                    dist[v] = curr.cost+wt;
                    q.add(new Info(v,dist[v],curr.stops+1));
                }
            }
        }

        if (dist[dest] == Integer.MAX_VALUE){
            return -1;
        } else {
            return dist[dest];
        }
    }
    public static void main(String[] args) {
        
        int n = 4;
        int src = 0;
        int dest = 3;
        int k = 1;
        int flights[][] = {{0,1,100} , {1,2,100} , {2,0,100} , {1,3,600} , {2,3,200}};
        System.out.println(cheapFlight(flights,src,dest,k,n));
    }
}