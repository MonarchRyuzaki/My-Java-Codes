import java.util.*;
class ihpwn
{
    public static void main(String args[])
    {
        int i,j,k,n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of lines");
        n = sc.nextInt();
        for (i=1;i<=n;i++)
        {
            j=1;
            for (k=n;k>=i;k--)
            {
                System.out.print(j++);
            }
            System.out.println();
        }
    }
}