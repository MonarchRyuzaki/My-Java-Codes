import java.util.*;
class SortedArray
{
    public static boolean checkSorted(int arr[],int i)
    {
        if (i==arr.length-1)
            return true;
        if (!(arr[i]<arr[i+1]))
            return false;
        i++;
        return checkSorted(arr, i);
        
    }
    public static void main (String args[])
    {
        int arr[] = {1, 2, 3, 5, 4};
        int i=0;
        System.out.println(checkSorted(arr,i));
    }
}
