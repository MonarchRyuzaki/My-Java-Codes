import java.util.*;
class LargestElement
{
    public static void main(String args[])
    {
        int i,j;
        int arr[] = new int[5];
        Scanner sc = new Scanner (System.in);
        for (i=0;i<5;i++)
        {
            arr[i]=sc.nextInt();
        }
        j=Integer.MIN_VALUE;
        for (i=0;i<5;i++)
        {
            if (arr[i]>j)
            {
                j=arr[i];
            }
        }
        System.out.println(j);
    }
}