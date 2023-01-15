import java.util.*;
class palinpyr
{
    public static void main (String args[])
    {
        int i , j ,k , n,t,b;
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter No of lines");
        n=sc.nextInt();
        for (i=1;i<=n;i++)
        {
            t=i;
            for (k=n;k>=i;k--)
            {
                System.out.print(" ");
            }
            for (j=1;j<=i;j++)
            {
                System.out.print((t--));
            }
            if (i!=1)
            {
                for (b=2;b<=i;b++)
                    System.out.print(b);
            }
            System.out.println();
        }
    }
}