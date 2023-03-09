public class FloydWarshall {
    //Stores Shortest Path for each Pair
    public void shortest_distance(int[][] matrix)
    {
        int n = matrix.length;
        for (int k=0; k<n; k++){
            for (int i=0; i<n; i++){
                for (int j=0; j<n; j++){
                    if (matrix[i][k] != -1 && matrix[k][j] != -1) {
                        int newDistance = matrix[i][k] + matrix[k][j];
                        if (matrix[i][j] == -1 || newDistance < matrix[i][j]) {
                            matrix[i][j] = newDistance;
                        }
                    }
                }
            }
        }
    }
}
