import java.util.*;

public class MaxChainLength {
    public static void main(String[] args) {
        int pairs[][] = {{5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};

        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        int maxAct =0;
        int lastEnd=0;

        maxAct=1;
        lastEnd=pairs[0][1];

        for (int i=1;i<pairs.length;i++){
            if (pairs[i][0] > lastEnd){
                maxAct++;
                lastEnd = pairs[i][1];
            }
        }

        System.out.println("Length of the Longest Chain :"+ maxAct);
    }
}
