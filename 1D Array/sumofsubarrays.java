import java.util.*;
class sumofsubarrays
{
    public static void print_subarrays(int arr[])
    {
        int i,j,k,c=0,f,sum=0;
        int arr_sum[]= new int[6];
        for (i=0;i<arr.length;i++)
        {
            for (j=i;j<arr.length;j++)
            {
                c=0;sum=0;
                for (k=i;k<=j;k++)
                {
                    arr_sum[c++]=arr[k];
                    System.out.print(arr[k]+",");
                }
                for (f=0;f<=c;f++)
                {
                    sum = sum+arr_sum[f];
                }
                System.out.print("       Sum = "+ sum);
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
