import java.util.*;
public class test {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static int[] repeatedNumber(int[] A) {
        int i, len=A.length;
        Arrays.sort(A);
        int B[] = new int[2];B[0]=0;B[1]=0;
        for (i=0;i<len-1;i++)
        {
            if (A[i]==A[i+1])
                B[0]=A[i];
            else
                B[0]=0;
            if (A[i+1]-A[i]==2)
                B[1]=A[i]+1;
            else
                B[1]=0;
        }
        return B;
    }
    public static void main (String args[])
    {
        int A[]={3,1, 2, 5, 3};
        System.out.println(repeatedNumber(A));
    }
}
