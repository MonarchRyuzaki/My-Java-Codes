import java.util.*;
class primeopt
{
    public static int checkPrime(int n)
    {
        int i;
        if (n==2)
            return 1;
        for (i=2;i<=Math.sqrt(n);i++)
        {
            if (n%i==0)
                return 0;
        }
        return 1;
    }
    public static void main(String args[])
    {
        int ll,t,i,ul;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter lowest limit");
        ll=sc.nextInt();
        System.out.println("Enter upper limit");
        ul=sc.nextInt();
        // if (t== 1)
        //     System.out.println("Prime");
        // else
        //     System.out.println("Not Prime");
        System.out.println("Prime numbers in range");
        for (i=ll;i<=ul;i++)
        {
            if (checkPrime(i)==1)
                System.out.println(i);
        }
        
    }
}