import java.util.ArrayList;

public class IndianCoins {
    public static void main(String[] args) {
        int coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000};
        int count =0;
        int amt = 5900;

        ArrayList<Integer> list = new ArrayList<>();
        for (int i=coins.length-1 ; i>=0;i--){
            if (coins[i] <= amt){
                while (coins[i] <= amt){
                    count++;
                    list.add(coins[i]);
                    amt=amt-coins[i];
                }
            }
        }
        
        System.out.println("Min no of Coins : "+count);

        for (int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
    }
}
