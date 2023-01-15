import java.util.*;
class numpyr
{
    public static void main(String args[])
    {
        int i , j , k , n ;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter No of Lines");
        n=sc.nextInt();
        for (i=1;i<=n;i++)
        {
            for (k=n;k>=i;k--)
            {
                System.out.print(" ");
            }
            for (j=1;j<=i;j++)
            {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}