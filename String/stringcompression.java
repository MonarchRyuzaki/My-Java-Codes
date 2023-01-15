import java.util.*;
class stringcompression
{
    public static void compression (String str)
    {
        StringBuilder sb = new StringBuilder("");
        int i , len = str.length(); int count=1;
        for (i=0;i<len-1;i++)
        {
            if (str.charAt(i)==str.charAt(i+1))
            {
                count++;
            }
            else
            {
                sb.append(str.charAt(i));
                if (count > 1)
                {
                    sb.append(count);
                    count=1;
                }
            }
            
        }
        System.out.println(sb.toString());
    }
    public static void main (String args[])
    {
        String str = "abcccd";
        str = str + " ";
        compression(str);
    }
}