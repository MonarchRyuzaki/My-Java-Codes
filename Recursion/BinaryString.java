import java.util.*;
class BinaryString
{
    public static void prinBinString(int n,int lastPos,String str)
    {
        if (n==0)
        {
            System.out.println(str);
            return ;
        }
        prinBinString(n-1,0,str+"0");
        if (lastPos==0)
            prinBinString(n-1,1,str+"1");
    }
    public static void main (String args[])
    {
        prinBinString(3,0,"");
    }
}
