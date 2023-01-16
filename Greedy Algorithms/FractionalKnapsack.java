import java.util.*;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int weight[] = {10, 20};
        int val[] = {60, 100};
        int W = 50;

        double ratio[][] = new double[weight.length][2];
        
        for (int i=0;i<weight.length;i++){
            ratio[i][0]=i;
            ratio[i][1]= val[i]/(double)weight[i];
        }

        Arrays.sort(ratio , Comparator.comparingDouble(o -> o[1]));

        int capacity = W;
        int finalVal = 0;
        for (int i=val.length-1;i>=0;i--){
            int idx = (int)ratio[i][0];
            if (capacity >= weight[i]){
                capacity -= weight[i];
                finalVal+= val[i];
            } else {
                finalVal+=  ratio[i][1]*capacity;
            }
        }

        System.out.println("Maximum Value : "+ finalVal);
    }
}
