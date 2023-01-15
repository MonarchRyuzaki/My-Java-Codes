import java.util.*;
class DuplicateFreq
{
    public static void duplicate(String str)
    {
        str=str.toLowerCase();
        int arr[] = new int [26];
        for (int i=0;i<str.length();i++)
        {
            arr[((int)str.charAt(i))-97]++;
        }
        for (int i=0;i<26;i++)
        {
            if (arr[i]>1)
                System.out.println((char)(i+97) +"count: "+arr[i]);
        }
    }
    public static void main(String args[])
    {
        String str = "geeksforgeeks";
        duplicate(str);
    }
}