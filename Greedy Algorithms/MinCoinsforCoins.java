import java.util.*;

public class MinCoinsforCoins {
    public static int coinsForCoint(int coins[],int k){
        Arrays.sort(coins);
        int end = coins.length;
        int amt = 0;
        for (int i=0 ; i<end; i++){
            amt += coins[i];
            end -= k;
        }
        return amt;
    }
    public static void main(String[] args) {
        int coin[] = {1, 2, 5, 10, 20, 50};
        int k = 3;
        System.out.println(coinsForCoint(coin, k));
    }
}