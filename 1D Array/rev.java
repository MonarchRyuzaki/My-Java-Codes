import java.util.*;
class rev
{
    public static void main (String args[])
    {
        int arr[] = {2,4,6,10,12,14,16};int i,t,last=arr.length-1;
        for (i=0;i<arr.length/2;i++)
        {
            t=arr[i];
            arr[i]=arr[last];
            arr[last] = t;
            last--;
        }
        for (i=0;i<arr.length;i++)
        {
            System.out.println(arr[i]);
        }
    }

}
