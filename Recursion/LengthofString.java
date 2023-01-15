import java.util.*;
class LengthofString
{
    public static int calcLength(String str,int len,String s)
    {
        if (s.equals(str)==true){
            return len;
        }
        s=s+str.charAt(len);
        return calcLength(str,len+1,s);        
    }
    public static void main (String args[])
    {
        String str="2019";
         System.out.println(calcLength(str,0,""));  
    }
}
