import java.util.ArrayList;

public class NumberOfTriangles {
    public static int countTriangles(int digraph[][], boolean isDirected){
        int count = 0;
        int n = digraph.length;
        for (int i=0; i<n ;i++){
            for (int j=0; j<n; j++){
                for (int k=0; k<n; k++){
                    if (digraph[i][j] == 1 && digraph[k][i] == 1 && digraph[j][k] == 1){
                        count++;
                    }
                }
            }
        }

        if (isDirected){
            count = count/3;
        } else {
            count = count/6;
        }
        return count;
    }
    public static void main(String[] args) {
        int graph[][] = {{0, 1, 1, 0},
                        {1, 0, 1, 1},
                        {1, 1, 0, 1},
                        {0, 1, 1, 0}
                       };
     
       // Create adjacency matrix
       // of a directed graph
       int digraph[][] = { {0, 0, 1, 0},
                           {1, 0, 0, 1},
                           {0, 1, 0, 0},
                           {0, 0, 1, 0}
                         };
        int V =4;
        System.out.println(countTriangles(graph, false));
    }
}
