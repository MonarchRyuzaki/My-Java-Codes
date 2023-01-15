import java.util.*;
class TowerofHanoi
{
    public static void Tower(int n, String src,String helper,String dest)
    {
        if (n==1)
        {
            System.out.println("Transfered Disk "+n+" from "+src+" to "+dest);
            return ;
        }
        Tower(n-1,src,dest,helper);
        System.out.println("Transfered Disk "+n+" from "+src+" to "+dest);
        Tower(n-1,helper,src,dest);
    }
    public static void main(String args[])
    {
        int n=3;
        Tower(n,"S","H","D");
    }
}