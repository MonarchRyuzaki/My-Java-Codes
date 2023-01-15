import java.util.*;
class ExponentOptimized
{
    public static int pow(int x,int n)
    {
        if (n==0)
            return 1;
        int hpsq=pow(x,n/2)*pow(x,n/2);
        if (n%2==1)
            hpsq=x*hpsq;
        return hpsq;
    }
    public static void main (String args[])
    {
        System.out.println(pow(2,10));
    }
}
