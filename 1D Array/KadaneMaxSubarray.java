import java.util.*;
class KadaneMaxSubarray
{
    public static void kadane(int arr[])
    {
        int i,cs=0,ms=Integer.MIN_VALUE;
        for (i=0;i<arr.length;i++)
        {
            cs=cs+arr[i];
            if (cs<0)
                cs=0;
            ms = Math.max(cs , ms);
        }
        System.out.println("The Max Subarray Sum:"+ms);
    }
    public static void main (String args[])
    {
        int arr[] = {-2,-3,4,-1,-2,1,5,-3};
        kadane(arr);
    }
}