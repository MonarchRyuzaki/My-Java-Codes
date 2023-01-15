import java.util.*;
class MaxSumofSubarrayPrefixArray
{
    public static void print_subarrays(int arr[])
    {
        int i,j,sum=0;
        int ms;
        ms=Integer.MIN_VALUE;
        //prefix array -- -sum of all nos upto that index
        int prefix[]=new int[arr.length];
        prefix[0]=arr[0];
        for (i=1;i<arr.length;i++)
        {
            prefix[i]=prefix[i-1]+arr[i];
        }
        
        for (i=0;i<arr.length;i++)
        {
            for (j=i;j<arr.length;j++)
            {
                sum= (i==0)?(prefix[j]-prefix[0]):(prefix[j]-prefix[i-1]);
                if (ms<sum)
                    ms=sum;
            }
        }
        System.out.println("The Maximum Sum is "+ ms);
    }
    public static void main (String args[])
    {
        int arr[] = {1,-2,6,-1,3};
        print_subarrays(arr);
        System.out.println(1%2);
    }
}
