import java.util.PriorityQueue;

public class PathWithMinimumEffort {
    static class Info implements Comparable<Info>{
        int value;
        int row;
        int col;
        Info(int value,int row,int col){
            this.value = value;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Info i){
            return this.value - i.value;
        }
    }
    static int sum=0;
    public static boolean isSafe(int visited[][],int row,int col){ 
        return ((row>=0 && row<visited.length) && (col>=0 && col<visited.length) && visited[row][col]==0);
    }
    public static void minEffort(int arr[][],int visited[][],int row,int col){
        if (row == arr.length-1 && col==arr.length-1){
            sum = sum+arr[row][col];
            return;
        }
        if (isSafe(visited, row, col)){
            visited[row][col]=1;
            sum = sum + arr[row][col];
            PriorityQueue<Info> pq = new PriorityQueue<>();
            if (isSafe(visited, row+1, col)){       //Go Down
                pq.add(new Info(arr[row+1][col],row+1,col));
            }
            if (isSafe(visited, row, col+1)){       //Go Right
                pq.add(new Info(arr[row][col+1],row,col+1));
            }
            if (isSafe(visited, row-1, col)){       //Go Up
                pq.add(new Info(arr[row-1][col],row-1,col));
            }
            if (isSafe(visited, row, col-1)){       //Go Left
                pq.add(new Info(arr[row][col-1],row,col-1));
            }
            Info data = pq.remove();
            minEffort(arr, visited, data.row, data.col);
        }

    }
    public static void main(String[] args) {
        int arr[][] = { { 31, 100, 65, 12, 18 },
        { 10, 13, 47, 157, 6 },
        { 100, 113, 174, 11, 33 },
        { 88, 124, 41, 20, 140 },
        { 99, 32, 111, 41, 20 } } ;
        int n = arr.length;
        int visited[][] = new int[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                visited[i][j]=0;
            }
        }
        minEffort(arr, visited, 0, 0);
        System.out.println(sum);
    }
}
