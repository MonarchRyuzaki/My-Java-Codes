import java.util.*;
class shortestpath
{
    public static void path(String str)
    {
        int i,len=str.length(),starting_x=0,starting_y=0;
        for (i=0;i<len;i++)
        {
            if (str.charAt(i)=='W')
                starting_x--;
            else if (str.charAt(i)=='N')
                starting_y++;
            else if (str.charAt(i)=='S')
                starting_y--;
            else
                starting_x++;
        }
        double shortestdist=Math.sqrt(Math.pow(starting_x,2)+Math.pow(starting_y,2));
        System.out.println("Shortest Distance :"+shortestdist);
    }
    public static void main (String args[])
    {
        String str="WNEENESENNN";
        path(str);
    }
}