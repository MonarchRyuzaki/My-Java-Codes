import java.util.*;
class charpattern
{
    public static void main (String args[])
    {
        int i,j,k=65,n;
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter number of lines");
        n=sc.nextInt();
        for (i=1;i<=n;i++)
        {
            for (j=1;j<=i;j++)
            {
                System.out.print((char)k);
                k++;
            }
            System.out.println();
        }
    }
}