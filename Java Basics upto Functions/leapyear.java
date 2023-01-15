import java.util.*;
class leapyear
{
    public static void main (String args[])
    {
        int year;
        Scanner sc= new Scanner (System.in);
        System.out.println("Enter a year");
        year = sc.nextInt();
        boolean x,y,z;
        x=(year%4==0);
        y=(year%100==0);
        z=(year%400==0);
        if (x==true)
        {
            if (y==true)
            {
                if (z==true)
                    System.out.println("Leap Year");
                else
                    System.out.println("Not Leap Year");
            }
            else 
                System.out.println("Leap Year");
        }
        else
            System.out.println("Not Leap Year");
    }

}