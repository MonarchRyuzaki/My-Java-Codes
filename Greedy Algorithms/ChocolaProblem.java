import java.util.*;

public class ChocolaProblem {
    public static void main(String[] args) {
        int n = 4, m = 6;
        Integer costVer[] = {2, 1, 3, 1, 4}; //m-1
        Integer costHor[] = {4, 1, 2}; //n-1

        Arrays.sort(costHor, Collections.reverseOrder());
        Arrays.sort(costVer, Collections.reverseOrder());

        int hp=1, vp=1;
        int h=0,v=0;
        int cost=0;
        while (h<costHor.length && v<costVer.length){
            if (costHor[h]<costVer[v]){
                cost += costVer[v]*hp;
                v++;
                vp++;
            } else {
                cost += costHor[h]*vp;
                h++;
                hp+=1;
            }
        }

        while (h<costHor.length){
            cost += costHor[h]*vp;
            h++;
            hp++;
        }

        while (v<costVer.length){
            cost += costVer[v]*hp;
            v++;
            vp++;
        }

        System.out.println("Min Cost : "+ cost);
    }
}
