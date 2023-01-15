import java.util.*;
class nthfibonacci
{
    public static int calcFibo(int n)
    {
        if (n==0)
            return 0;
        if (n==1)
            return 1;
        return calcFibo(n-1)+calcFibo(n-2);
    }
    public static void main (String args[])
    {
        int n=5;
        System.out.println(calcFibo(n));
    }
}
