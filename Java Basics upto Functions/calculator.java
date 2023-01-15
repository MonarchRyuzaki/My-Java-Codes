import java.util.*;
class calculator
{
    public static void main (String args[])
    {
        int i,a,b,res=0;
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Modulo");
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter your choice");
        i = sc.nextInt();
        System.out.println("Enter 2 numbers");
        a=sc.nextInt();
        b=sc.nextInt();
        switch (i)
        {
            case 1:
            {
                res = a+b;
                break;
            }
            case 2:
            {
                res = a-b;
                break;
            }
            case 3:
            {
                res = a*b;
                break;
            }
            case 4:
            {
                res = a/b;
                break;
            }
            case 5:
            {
                res = a%b;
                break;
            }
        }
        System.out.println("The result : "+res);
    }
}