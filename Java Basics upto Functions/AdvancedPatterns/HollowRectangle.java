import java.util.*;
class HollowRectangle
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
        int m , n ,j;
        HollowRectangle ob = new HollowRectangle();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter No of Rows");
        m=sc.nextInt();
        System.out.println("Enter No of Columns");
        n=sc.nextInt();
        for(j=1;j<=m;j++)
        {
            if (j==1||j==m)
                ob.boundary(n);
            else
                ob.nonboundary(n);
        }
    }
}