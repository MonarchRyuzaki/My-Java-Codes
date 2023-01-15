import java.util.*;
class irhp
{
    public static void main(String args[])
    {
        int i,j,k,n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of lines");
        n = sc.nextInt();
        for (i=1;i<=n;i++)
        {
            for (k=n;k>=i;k--)
            {
                System.out.print(" ");
            }
            for (j=1;j<=i;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}