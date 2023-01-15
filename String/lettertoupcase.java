import java.util.*;
class lettertoupcase
{
    public static void getUpperCase(String str)
    {
        StringBuilder sb = new StringBuilder("");int i;
        str = " "+str;
        for (i=0;i<str.length();i++)
        {
            if (str.charAt(i)== ' ')
            {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }
            else
            {
                sb.append(str.charAt(i));
            }
        }
        System.out.println((sb.toString()).trim());
    }
    public static void main (String args[])
    {
        String str="   hi, i am shivam   ";
        str=str.trim();
        getUpperCase(str);
    }
}