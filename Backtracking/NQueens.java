public class NQueens {
    static int count =0;
    public static void nQueens(char board[][],int row){
        //base
        if (row==board.length){
            count++;
            printBoard(board);
            return;
        }

        //kaam
        for (int j=0;j<board.length;j++){
            if (isSafe(board, row, j)==true){
                board[row][j]='Q';
                nQueens(board, row+1);
                board[row][j]='x';
            }
        }
    }
    public static boolean checkQueens(char board[][],int row){
        //base
        if (row==board.length){
            //count++;
            printBoard(board);
            return true;
        }

        //kaam
        for (int j=0;j<board.length;j++){
            if (isSafe(board, row, j)==true){
                board[row][j]='Q';
                if (checkQueens(board, row+1)==true){
                    return true;
                }
                board[row][j]='x';
            }
        }
        return false;
    }
    public static boolean isSafe(char board[][] , int row , int col){
        int i,j;
        //vertically up
        for (i=row-1;i>=0;i--){
            if (board[i][col]=='Q'){
                return false;
            }
        }
        //left diagonal up
        for (i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if (board[i][j]=='Q'){
                return false;
            }
        }
        //right diagonal up
        for (i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if (board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    public static void printBoard(char board[][]){
        System.out.println(("---------CHESS BOARD-------"));
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        
        }
    }
    public static void main(String[] args) {
        int n=5;
        char board[][]=new char[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                board[i][j]='x';
            }
        }
        //nQueens(board, 0);
        System.out.println(checkQueens(board, 0));

    }
}