import java.util.*;
class largestof3
{
    public static void main (String args[])
    {
        int x,y,z;
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter 3 number");
        x=sc.nextInt();
        y=sc.nextInt();
        z=sc.nextInt();
        if ((x>y)&&(x>z))
        {
            System.out.println(x +" is the largest");
        }
        else if (y>z)
        {
            System.out.println(y +" is the largest");
        }
        else
        {
            System.out.println(z +" is the largest");
        }

    }
}