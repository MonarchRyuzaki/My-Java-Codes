public class PaperCutIntoMinSquares {

    static int count = 0;
    public static void countSq(int l,int b){
        if (l>b){
            int temp = l;
            l = b;
            b = temp;
        }
        if (l==0 || b==0){
            System.out.println(count);
            return;
        }
        int x = b/l;
        count += x;
        countSq(l , b-x*l);
    }

    public static void main(String[] args) {
        countSq(29 , 13);
    }
}
