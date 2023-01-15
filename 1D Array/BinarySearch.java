import java.util.*;
class BinarySearch
{
    public static int binarySearch(int numbers[] , int key)
    {
        int lb=0,ub=numbers.length-1,mid;
        while (lb<=ub)
        {
            mid = (lb+ub)/2;
            if (numbers[mid]==key)
                return mid;
            if (numbers[mid]>key)
            {
                ub=mid-1;
            }
            if (numbers[mid]<key)
            {
                lb=mid+1;
            }
        }
        return -1;
    }
    public static void main (String args[])
    {
        int numbers[] = {2,4,6,10,12,14};
        int key = 10;int p;
        p=binarySearch(numbers,key);
        if (p==-1)
            System.out.println("not found");
        else
            System.out.println("Found at "+(p+1)+" position");
    }
}