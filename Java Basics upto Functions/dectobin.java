import java.util.*;
class dectobin
{
    public static void main(String args[])
    {
        int n;String s="";int r;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        n= sc.nextInt();
        while (n>0)
        {
            r=n%2;
            s=r+s+"";
            n=n/2;
        }
        System.out.println("The Binary Number: "+s);
    }
}