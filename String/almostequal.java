import java.util.*;
class almostequal
{
    public static int almmostEqual(String s1,String s2)
    {
        int i,k,count=0;
        int freq1[] = new int [26];
        int freq2[] = new int [26];
        for (i=0;i<s1.length();i++)
        {
            k = (int)(s1.charAt(i));
            freq1[k-97]++;
        }
        for (i=0;i<s2.length();i++)
        {
            k = (int)(s2.charAt(i));
            freq2[k-97]++;
        }
        for (i=0;i<26;i++)
        {
            if (freq1[i]!=freq2[i])
            {
                count+=Math.abs(freq1[i]-freq2[i]); 
            }
        }
        return count;
    }
    public static void main (String args[])
    {
        String s1 = "maasdamasdasdase";
        String s2 = "madam";
        int p = almmostEqual(s1,s2);
        System.out.println("The no of character to be deleted :"+p);
    }
}