import java.util.*;
class spiralmatrix
{
    public static void spiral(int matrix[][])
    {
        int startRow=0;int i,j;
        int startCol=0;
        int endRow=matrix.length-1;
        int endCol=matrix[0].length-1;
        while (startRow <= endRow && startCol<=endCol)
        {
            //top soja
            for (j=startCol;j<=endCol;j++)
                System.out.print(matrix[startRow][j]+" ");
            
            //right soja
            for (i=startRow+1;i<=endRow;i++)
                System.out.print(matrix[i][endCol]+" ");

            //bot ulto
            for (j=endCol-1;j>=startCol;j--)
            {
                if (startRow==endRow)
                {
                    break;
                }
                System.out.print(matrix[endRow][j]+" ");
            }
            //left ulto
            for (i=endRow-1;i>=startRow+1;i--)
            {
                if (startCol==endCol)
                {
                    break;
                }
                System.out.print(matrix[i][startCol]+" ");
            }           
            startRow++;
            startCol++;
            endCol--;
            endRow--;
        }
    }
    public static void main (String args[])
    {
        int matrix[][] = {{1,2,3,4},
                          {5,6,7,8},
                          {9,10,11,12},
                          {13,14,15,16}};
        spiral(matrix);
    }
}