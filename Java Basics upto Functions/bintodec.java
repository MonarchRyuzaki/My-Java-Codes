import java.util.*;
class bintodec
{
    public static void main (String args[])
    {
        int n,m=0,k=0,r;
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter a Binary Number");
        n = sc.nextInt();
        while (n>0)
        {
            r = n%10;
            m=m+(int)(r*Math.pow(2,k));
            n=n/10;
            k++;
        }
        System.out.println("The nummber in Decimal : "+ m);
    }
}