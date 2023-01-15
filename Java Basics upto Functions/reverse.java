import java.util.*;
class reverse 
{
    public static void main (String args[])
    {
        int n,r,s=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        n=sc.nextInt();
        while(n!=0)
        {
            r=n%10;
            s=10*s+r;
            n=n/10;
        }
        System.out.println("The reversed number is "+s);
    }
}