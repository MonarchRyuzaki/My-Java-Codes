public class KnightTour {
    static int n=8;   
    public static boolean knightTour(int chess[][],int row,int col,int count,int xMove[],int  yMove[]){
        int i , nr , nc;
        if (count == n*n){
            return true;
        }
        for (i=0;i<8;i++){
            nr = row+xMove[i];
            nc = col+yMove[i];
            if (isSafe(chess, nr, nc)){
                chess[nr][nc]=count;
                if (knightTour(chess, nr, nc, count++,xMove,yMove))
                    return true;
                else 
                    chess[nr][nc]=-1;
            }
        }
        return false;
    }
    public static boolean isSafe(int chess[][],int row,int col){
        if (row>=0 && row<n && col>=0 && col<n && chess[row][col]==-1){
            return true;
        }
        return false;
    }
    public static void printArr(int chess[][]){
        for (int i = 0 ;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.print(chess[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int chess[][] = new int [n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                chess[i][j]=-1;
            }
        }
        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};
        chess[0][0]=0;
        if (knightTour(chess, 0, 0, 1,xMove,yMove)==true){
            printArr(chess);
        } else {
            System.out.println("No Solution");
        }
    }
}
