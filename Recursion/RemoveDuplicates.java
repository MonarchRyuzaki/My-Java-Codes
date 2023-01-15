import java.util.*;
class RemoveDuplicates
{
    public static String remDup(int index, StringBuilder sb, boolean track[], String s)
    {
        if (index==s.length())
            return sb.toString();
        char ch = s.charAt(index);
        if (track[(int)(ch-'a')]==false)
        {
            track[(int)(ch-'a')]=true;
            sb.append(ch);
        }
        return remDup(index+1,sb,track,s);
    }
    public static void main (String args[])
    {
        StringBuilder sb = new StringBuilder("");
        boolean track[] = new boolean[26];
        String s = "appnnacollege";
        System.out.println(remDup(0,sb,track,s));
    }
}
