import java.util.*;
class Substrings
{
    public static void printSubstring(String str,int firstIndex,int lastIndex)
    {
        if (firstIndex==str.length()){
            return ;
        }
        if (str.charAt(firstIndex)==str.charAt(lastIndex))
        {
            System.out.println(str.substring(firstIndex,lastIndex+1));
        }
        if (firstIndex==lastIndex)
        {
            firstIndex=firstIndex+1;
            lastIndex=str.length();
        }
        printSubstring(str,firstIndex,lastIndex-1);        
    }
    public static void main (String args[])
    {
        String str="abcab";
        printSubstring(str,0,str.length()-1);  
    }
}
