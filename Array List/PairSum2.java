import java.util.ArrayList;

import javax.lang.model.util.ElementScanner14;

public class PairSum2 {
    public static boolean findPairSum2(ArrayList<Integer> list , int target){
        int pivot=-1,i,lp,rp,sum=0;
        for (i=0;i<list.size();i++){
            if (list.get(i)>list.get(i+1)){
                pivot=i;
                break;
            }
        }
        lp=pivot+1;
        rp = pivot;
        while (lp!=rp){
            sum=list.get(lp)+list.get(rp);
            if (sum==target)
                return true;
            else if (sum<target)
                lp++;
            else 
                rp--;
            if (rp==-1)
                rp = list.size()-1;
            if (lp==list.size())
                lp=0;
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        System.out.println(findPairSum2(list, 16));
    }
}
