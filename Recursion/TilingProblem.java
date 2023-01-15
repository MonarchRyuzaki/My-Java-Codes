import java.util.*;
class TilingProblem
{
    public static int calcWays(int n)
    {
        if (n==0 || n==1)
            return 1;
        return calcWays(n-1)+calcWays(n-2);
    }
    public static void main (String args[])
    {
        System.out.println(calcWays(4));
    }
}
