import java.util.*;

class GraphColoring {
    private int V; // Number of vertices in the graph
    private LinkedList<Integer>[] adj; // Adjacency list representation of the graph

    GraphColoring(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<Integer>();
    }

    // Function to add an edge to the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    // Function to assign colors to the vertices of the graph
    void colorGraph() {
        int[] result = new int[V]; // Stores the color assigned to each vertex
        Arrays.fill(result, -1); // Initialize all vertices as uncolored

        // Assign the first color to the first vertex
        result[0] = 0;

        // A temporary array to keep track of the colors assigned to the adjacent vertices
        boolean[] available = new boolean[V];
        Arrays.fill(available, true);

        // Iterate through all vertices and assign colors to them
        for (int u = 1; u < V; u++) {
            // Mark all the adjacent colors as unavailable
            for (int i=0; i<adj[u].size(); i++){
                int dest = adj[u].get(i);
                if (result[dest] != -1){
                    available[result[dest]] = false;
                }
            }

            // Find the first available color for the current vertex
            int c;
            for (c = 0; c < V; c++) {
                if (available[c])
                    break;
            }

            // Assign the found color to the current vertex
            result[u] = c;

            // Reset the availability of colors for the next iteration
            Arrays.fill(available, true);
        }

        // Print the color assigned to each vertex
        for (int u = 0; u < V; u++) {
            System.out.println("Vertex " + u + " ---> Color " + result[u]);
        }
    }
    public static void main(String[] args) {
        GraphColoring g = new GraphColoring(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        System.out.println("Coloring of the graph:");
        g.colorGraph();
    }
}