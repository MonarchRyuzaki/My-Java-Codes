import java.util.*;
class DSASheetQ5
{
    public static int chocolateDistribution(int arr[],int m)
    {
        int i,min=Integer.MAX_VALUE,diff=0;
        Arrays.sort(arr);
        for (i=0;i<=arr.length-m;i++)
        {
            diff=arr[i+m-1]-arr[i];
            min=Math.min(min,diff);
        }
        return min;
    }
    public static void main (String args[])
    {
        int arr[] = {12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50};
        int m=7;
        int p = chocolateDistribution(arr,m);
        System.out.println("Minimum Difference is "+p);
    }
}