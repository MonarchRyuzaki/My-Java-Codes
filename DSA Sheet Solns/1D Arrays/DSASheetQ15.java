import java.util.*;
class DSASheetQ15
{
    public static boolean pairs(int arr[] , int sum)
    {
        int i,n=arr.length,x,y;
        for (i=0;i<n;i++)
        {
            x=arr[i];
            y=sum-arr[i];
            int lb=0,ub=arr.length-1,mid;
            while (lb<=ub)
            {
                mid = (lb+ub)/2;
                if (arr[mid]==y)
                    return true;
                if (arr[mid]>y)
                {
                    ub=mid-1;
                }
                if (arr[mid]<y)
                {
                    lb=mid+1;
                }
            }
        }
        return false;
    }
    public static void main (String args[])
    {
        int arr[] = {11, 15, 6, 8, 9, 10};
        int sum = 35;
        System.out.println(pairs(arr,sum));
    }
}