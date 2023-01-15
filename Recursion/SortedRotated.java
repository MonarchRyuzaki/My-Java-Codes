import java.util.*;
class SortedRotated
{
    public static int printIndex (int arr[], int target , int si, int ei)
    {
        if (si>ei)
            return -1;
        //kaam
        int mid = si + (ei-si)/2;
        if (arr[mid]==target)
            return mid;
        // check on L1
        if (arr[si]<=arr[mid])
        {
            if (arr[si]<=target && target <arr[mid])
                return printIndex(arr,target,si,mid-1);
            else
                return printIndex(arr,target,mid+1,ei);
        }
        else
        {
            if (arr[mid]<target && target<=arr[ei])
                return printIndex(arr,target,mid+1,ei);
            else
                return printIndex(arr,target,si,mid-1);
        }
    }
    public static void main (String args[])
    {
        int arr[] = {4, 5, 6, 7, 0, 1, 2};
        int target=0;
        System.out.println(printIndex(arr,target,0,arr.length-1));
    }
}