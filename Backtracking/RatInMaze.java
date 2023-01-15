public class RatInMaze {
    public static boolean solveMaze (int maze[][]){
        int sol[][] = new int [maze.length][maze.length];
        for (int i=0;i<sol.length;i++){
            for (int j=0;j<sol.length;j++){
                sol[i][j]=0;
            }
        }
        if (solveMazeUtil(maze, 0, 0, sol)==false){
            System.out.println("No Solution is Possible");
            return false;
        }
        printArr(sol);
        return true;
    }
    public static boolean solveMazeUtil (int maze[][],int row,int col,int sol[][]){
        //(row,col) is goal
        if (maze[row][col]==1 && row == maze.length-1 && col == maze.length-1){
            sol[row][col]=1;
            return true;
        }
        // check if (row,col) is possible
        if (isSafe(maze, row, col)){
            //check if (row,col) already part of sol
            if (sol[row][col]==1){
                return false;
            }
            sol[row][col]=1;
            if (solveMazeUtil(maze, row, col+1, sol)){
                return true;
            }
            if (solveMazeUtil(maze, row+1, col, sol)){
                return true;
            }
            sol[row][col]=0;
        }
        return false;
    }
    public static boolean isSafe(int maze[][],int row,int col){
        if (row>=0 && row<=maze.length && col>=0 && col<=maze.length && maze[row][col]==1){
            return true;
        }
        return false;
    }
    public static void printArr(int sol[][]){
        for (int i=0;i<sol.length;i++){
            for (int j=0;j<sol.length;j++){
                System.out.print(sol[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int maze[][] = { { 1, 0, 0, 0 },
                         { 1, 1, 0, 1 },
                         { 0, 1, 0, 0 },
                         { 1, 1, 1, 1 } };
        solveMaze(maze);
    }
}
