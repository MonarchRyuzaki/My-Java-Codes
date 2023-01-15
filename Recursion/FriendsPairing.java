import java.util.*;
class FriendsPairing
{
    public static int calcWays(int n)
    {
        if (n==2 || n==1)
            return n;
        return calcWays(n-1)+(n-1)*calcWays(n-2);
    }
    public static void main (String args[])
    {
        System.out.println(calcWays(3));
    }
}
