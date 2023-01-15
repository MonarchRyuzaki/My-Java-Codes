import java.util.*;
class breakq
{
    public static void main (String args[])
    {
        int i,n;
        Scanner sc = new Scanner(System.in);
        while (true)
        {
            n=0;
            System.out.println("Enter a number");
            n=sc.nextInt();
            if (n%10==0)
            {
                break;
            }
        }
    }
}