import java.util.*;
class BuySellStock
{
    public static int maximise_Profit(int prices[])
    {
        int n=prices.length;int i;int max_profit = Integer.MIN_VALUE;int sp;int profit;
        int bp = Integer.MAX_VALUE;
        for (i=0;i<n;i++)
        {
            if (bp<prices[i])
                max_profit=Math.max(max_profit,(prices[i]-bp));
            else
                bp=prices[i];
        }
        if (max_profit<0)
            return 0;
        return max_profit;
    }
    public static void main (String args[])
    {
        int prices[]={7, 1, 5, 3, 6, 4};
        int maxp=maximise_Profit(prices);
        System.out.println("The maximum profit :"+maxp);
    }
}