import java.util.*;
class floyd
{
    public static void main(String args[])
    {
        int i,j,k=1,n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of lines");
        n = sc.nextInt();
        for (i=1;i<=n;i++)
        {
            for (j=1;j<=i;j++)
            {
                System.out.print(k++);
            }
            System.out.println();
        }
    }
}