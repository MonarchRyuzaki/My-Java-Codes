import java.util.*;
class nto1dec
{
    public static int dec(int n)
    {
        if (n==0)
            return 0;
        else
        {
        System.out.println(n);
        return dec(n-1);
        }
    }
    public static void main (String args[])
    {
        int n=10;
        dec(n);
    }
}
