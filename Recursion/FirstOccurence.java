import java.util.*;
class FirstOccurence
{
    public static int findIndex(int arr[],int i,int key)
    {
        if (i==arr.length)
            return -1;
        if (arr[i]==key)
            return i;
        return findIndex(arr, i+1 , key);
        
    }
    public static void main (String args[])
    {
        int arr[] = {8, 3, 6, 9, 5, 10, 2, 5, 3};
        System.out.println(findIndex(arr,0,5));
    }
}
