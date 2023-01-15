import java.util.*;
class HollowRhombus
{
    public void boundary(int n)
    {
        int a;
        for (a=1;a<=n;a++)
        {
            System.out.print("*");
        }
        System.out.println();
    }
    public void nonboundary(int n)
    {
        int a;
        for (a=1;a<=n;a++)
        {
            if (a==1||a==n)
                System.out.print("*");
            else
                System.out.print(" ");
        }
        System.out.println();
    }
    public static void main(String args[])
    {
        int n,k,i;
        HollowRhombus ob = new HollowRhombus();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter No of lines");
        n=sc.nextInt();
        for(i=1;i<=n;i++)
        {
            for (k=n;k>=i;k--)
            {
                System.out.print(" ");
            }
            if (i==1||i==n)
                ob.boundary(n);
            else
                ob.nonboundary(n);
        }
    }
}