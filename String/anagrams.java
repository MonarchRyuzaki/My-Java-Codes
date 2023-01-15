import java.util.*;
class anagrams
{
    public static boolean anagram(String str1,String str2)
    {
        if (str1.length()==str2.length())
        {
            char ch1[] = str1.toCharArray();
            char ch2[] = str2.toCharArray();
            Arrays.sort(ch1);
            Arrays.sort(ch2);
            if (Arrays.equals(ch1,ch2)==true)
                return true;
            else
                return false;
        }
        return false;
        
    }
    public static void main (String args[])
    {
        String str1 = "race";
        String str2 = "hell";
        boolean xyz = anagram(str1,str2);
        if (xyz==true)
            System.out.println("The Strings are anagrams");
        else
            System.out.println("The Strings are not anagrams");
    }
}