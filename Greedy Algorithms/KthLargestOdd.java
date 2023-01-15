public class KthLargestOdd {
    public static void main(String[] args) {
        int  L = -10, R = 10, K = 8;
        if (R%2==0){
            R=R-1;
        }
        if (L%2==0){
            L=L+1;
        }
        int i,count=1,val=0;
        boolean found = false;
        for (i=R;i>=L;i-=2){
            if (K==count){
                found = true;
                val = i;
                break;
            }
            count++;
        }
        if (found == true){
            System.out.println("The "+K+"th largest Odd Number : "+val);
        } else {
            System.out.println("Not Found");
        }
    }
}
