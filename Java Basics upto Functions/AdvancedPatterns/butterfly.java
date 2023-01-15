import java.util.*;
class butterfly
{
    public static void main (String args[])
    {
        int i , j , x , y ,k,n;
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter no of lines");
        n=sc.nextInt();
        for (i=1;i<=n;i++)
        {
            for (j=1;j<=i;j++)
            {
                System.out.print("*");
            }
            for (k=n-1;k>=i;k--)
            {
                System.out.print(" ");
            }
            for (k=n-1;k>=i;k--)
            {
                System.out.print(" ");
            }
            for (j=1;j<=i;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
        for (i=1;i<=n;i++)
        {
            for (j=n;j>=i;j--)
            {
                System.out.print("*");
            }
            if (i!=1)
            {
                 for (k=1;k<=i-1;k++)
                {
                    System.out.print(" ");
                }
                for (k=1;k<=i-1;k++)
                {
                    System.out.print(" ");
                }
            }
            for (j=n;j>=i;j--)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}