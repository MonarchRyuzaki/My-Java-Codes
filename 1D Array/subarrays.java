import java.util.*;
class subarrays
{
    public static void print_subarrays(int arr[])
    {
        int i,j,k;
        for (i=0;i<arr.length;i++)
        {
            for (j=i;j<arr.length;j++)
            {
                for (k=i;k<=j;k++)
                {
                    
                    System.out.print(arr[k]+",");
                }

                System.out.println();
            }
        System.out.println();
        }
    }
    public static void main (String args[])
    {
        int arr[] = {2,4,6,8,10};
        print_subarrays(arr);
    }
}