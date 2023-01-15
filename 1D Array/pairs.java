import java.util.*;
class pairs
{
    public static void main (String args[])
    {
        int arr[] = {2,4,6,10,12};int a,b;
        int i,j,len=arr.length;
        for (i=0;i<len;i++)
        {
            a=arr[i];
            for (j=i+1;j<len;j++)
            {
                b=arr[j];
                System.out.print("("+a+") , (" +b+")  ");
            }
            System.out.println();
        }
    }
}