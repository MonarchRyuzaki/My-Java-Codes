import java.util.*;
class YearWords
{
    public static void inWords(String word[],String year,int index,StringBuilder sb)
    {
        if (index==year.length()){
            System.out.println(sb.toString());
            return ;
        }
        char ch = year.charAt(index);
        sb.append(word[((int)ch)-48]);
        sb.append(" ");
        inWords(word,year,index+1,sb);        
    }
    public static void main (String args[])
    {
        String word[] = {"zero","one","two","three","four","five","six","swven","eight","nine"};
        String year="2019";
        inWords(word,year,0,new StringBuilder(""));  
    }
}
