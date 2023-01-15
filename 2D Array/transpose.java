import java.util.*;
class transpose
{
    public static void transpose(int matrix[][])
    {
        int row=matrix.length  , col=matrix[0].length , i,j;
        int transpose[][]=new int [col][row];
        for (i=0;i<row;i++)
        {
            for (j=0;j<col;j++)
                transpose[j][i]=matrix[i][j];
        }
        for (i=0;i<col;i++)
        {
            for (j=0;j<row;j++)
                System.out.print(transpose[i][j]+" ");
            System.out.println();
        }
    }
    public static void main (String args[])
    {
        int matrix[][] = {{10,20,30},
                          {15,25,35},
                          {27,29,37},
                          {32,33,39}};
        transpose(matrix);
    }
}