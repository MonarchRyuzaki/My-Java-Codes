import java.util.*;
class MobileNumeric
{
    public static void numericConversion(String str[] , String s)
    {
        StringBuilder sb = new StringBuilder("");
        int i , len = s.length();
        for (i=0;i<len;i++)
        {
            if (s.charAt(i)==' ')
                sb.append("0");
            sb.append(str[(int)(s.charAt(i)-'A')]);
        }
        System.out.println(sb.toString());
    }
    public static void main (String args[])
    {
        String str[] = {"2","22","222","3","33","333",
                        "4","44","444","5","55","555","6","66","666",
                        "7","77","777","7777","8","88","888","9","99","9999"};
        String s = "GEEKSFORGEEKS";
        numericConversion(str,s);
    }
}