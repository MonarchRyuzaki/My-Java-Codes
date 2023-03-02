import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class KruskalsAlgoMST {
    static class Edge implements Comparable<Edge>{
        int src;
        int dest;
        int wt;
        Edge(int s,int d,int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
        @Override
        public int compareTo(Edge o) {
            // TODO Auto-generated method stub
            return this.wt - o.wt;
        }
    }
    public static void createGraph(ArrayList<Edge> graph){
        graph.add(new Edge(0,1,10));
        graph.add(new Edge(1,0,10));
        graph.add(new Edge(1,3,40));
        graph.add(new Edge(3,1,40));
        graph.add(new Edge(0,3,30));
        graph.add(new Edge(3,0,30));
        graph.add(new Edge(0,2,15));
        graph.add(new Edge(2,0,15));
        graph.add(new Edge(2,3,50));
        graph.add(new Edge(2,3,50));

    }
    static int n = 4;
    static int par[] = new int[n];
    static int rank[] = new int[n];
    public static void init(){
        for (int i=0; i<par.length; i++){
            par[i] = i;
        }
    }
    public static int find(int x){ //Supreme wala parent return hoga yaha se
        if (x == par[x]){
            return x;
        }
        par[x] = find(par[x]);
        return par[x];
    }
    public static void union(int a, int b){
        int parA = find(a);
        int parB = find(b);
        if (rank[parA] == rank[parB]){
            par[parB] = parA;
            rank[parA]++; 
        } else if (rank[parA] > rank[parB]){
            par[parB] = parA;
        } else {
            par[parA] = parB;
        }
    }
    public static int kruskalMST(ArrayList<Edge> graph, int V){
        init();
        Collections.sort(graph);
        int mstCost = 0;
        int count=0;

        for (int i=0; count<V-1 ;i++){
            Edge e = graph.get(i);
            int parA = find(e.src);
            int parB = find(e.dest);
            if (parA != parB){
                union(e.src,e.dest);
                mstCost += e.wt;
                count++;
            }
        }

        return mstCost;
        
    }
    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph = new ArrayList<>();//Initially null rahega

        createGraph(graph);
        System.out.println(kruskalMST(graph,V));
    }
}