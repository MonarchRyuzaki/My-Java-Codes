import java.util.*;
class diamond
{
    public static void main (String args[])
    {
        int i,j,k,n,b;
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter No of lines");
        n = sc.nextInt();
        for (i=1;i<=n;i++)
        {
            for (k=n-1;k>=i;k--)
            {
                System.out.print(" ");
            }
            for (j=1;j<=(2*i-1);j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
        for (i=n,b=1;i>=1;i--,b++)
        {
            if (b!=1)
            {
                for (k=1;k<=b-1;k++)
                {
                    System.out.print(" ");
                }
            }
            for (j=(2*i-1);j>=1;j--)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}