import java.util.*;
class sum
{
    public static int sumNatural(int n)
    {
        if (n==0)
            return 0;
        return n+sumNatural(n-1);
    }
    public static void main (String args[])
    {
        int n=10;
        System.out.println(sumNatural(n));
    }
}
