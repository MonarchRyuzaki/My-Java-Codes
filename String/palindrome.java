import java.util.*;
class palindrome
{
    public static boolean palin_check(String str)
    {
        int i,len=str.length();char ch;String x="";
        for (i=0;i<len/2;i++)
        {
            if (str.charAt(i)!=str.charAt(len-1-i))
                return false; 
        }
        return true;
    }
    public static void main (String args[])
    {
        String str = "noon";boolean f;
        f=palin_check(str);
        if (f==true)
            System.out.println("Palindrome");
        else
            System.out.println("Not a Palindrome");
    }
}