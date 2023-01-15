import java.util.*;//4       double
public class cost
{
    public static void main (String args[])
    {
        float a,b,c,tax,sum;
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter cost of pen");
        a=sc.nextFloat();
        System.out.println("Enter cost of pencil");
        b=sc.nextFloat();
        System.out.println("Enter cost of eraser");
        c=sc.nextFloat();
        sum = a+b+c;
        tax=0.18f*sum;
        System.out.println("The cost is "+(sum+tax));
    }
}

