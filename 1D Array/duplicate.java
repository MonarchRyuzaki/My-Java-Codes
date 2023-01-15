import java.util.*;
class duplicate
{
    public static int check_Duplicate(int arr[])
    {
        int i,n=arr.length,c,j,k=0;
        for (i=0;i<n;i++)
        {
            c=arr[i];
            for (j=0;j<n;j++)
            {
                if (c==arr[j])
                    k++;
            }
        }
        return k;
    }
    public static void main (String args[])
    {
        int n,i,o;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of elements");
        n=sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter your entry");
        for (i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        o=check_Duplicate(arr);
        if (o>n)
            System.out.println("true");
        else
            System.out.println("false");
    }
}