import java.util.*;
class MaxSumofSubarraysBrutexForce
{
    public static void print_subarrays(int arr[])
    {
        int i,j,k,c=0,f,sum=0;
        int ms;
        ms=Integer.MIN_VALUE;
        for (i=0;i<arr.length;i++)
        {
            for (j=i;j<arr.length;j++)
            {
                c=0;sum=0;
                for (k=i;k<=j;k++)
                {
                    sum=sum+arr[k];
                }
                if (ms<sum)
                    ms=sum;
                System.out.println();
            }
        System.out.println();
        }
        System.out.println("The Maximum Sum is "+ ms);
    }
    public static void main (String args[])
    {
        int arr[] = {2,4,6,8,10};
        print_subarrays(arr);
    }
}
