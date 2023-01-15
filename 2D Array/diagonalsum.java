import java.util.*;
class diagonalsum
{
    public static void diaSum(int matrix[][])
    {
        int i,sum=0;
        for (i=0;i<matrix.length;i++)
        {
            sum+=matrix[i][i];
            if (i!=matrix.length-1-i)
                sum+=matrix[i][matrix.length-1-i];
        }
        System.out.println(sum);
    }
    public static void main (String args[])
    {
        int matrix[][] = {{1,2,3},
                          {5,6,7},
                          {13,14,15}};
        diaSum(matrix);
    }
}