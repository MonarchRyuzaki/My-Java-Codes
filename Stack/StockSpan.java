import java.util.Stack;

public class StockSpan {
    public static void findSpan(int stocks[], int span[]){
        Stack<Integer> idxOfPrevHigh = new Stack<>();
        span[0]=1;
        idxOfPrevHigh.push(0);
        int prevHigh;
        for (int i=1;i<span.length;i++){
            int currPrice = stocks[i];
            while (!idxOfPrevHigh.isEmpty() && currPrice>stocks[idxOfPrevHigh.peek()]){
                idxOfPrevHigh.pop();
            }
            if (idxOfPrevHigh.isEmpty()){
                span[i] = i+1;
            } else {
                prevHigh = idxOfPrevHigh.peek();
                span[i] = i - prevHigh;
            }
            idxOfPrevHigh.push(i);
        }
    }
    public static void main(String[] args) {
        int stocks[] = {100, 80, 60, 70, 60, 85, 100};
        int span[] = new int[stocks.length];
        findSpan(stocks,span);
        for (int i=0;i<span.length;i++){
            System.out.print(span[i]+" ");
        }
    }
}
