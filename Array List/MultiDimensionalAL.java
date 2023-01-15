import java.util.ArrayList;

public class MultiDimensionalAL {
    public static void store(ArrayList<Integer> list ,int n){
        int i;
        for (i=1;i<=5;i++){
            list.add(n*i);
        }
    } 
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        store(list1, 1);
        store(list2, 2);
        store(list3, 3);
        mainList.add(list1);
        mainList.add(list2);
        mainList.add(list3);
        for (int i=0;i<mainList.size();i++){
            ArrayList<Integer> currList = mainList.get(i);
            for (int j=0;j<currList.size();j++){
                System.out.print(currList.get(j)+" ");
            }
            System.out.println();
        }
        System.out.println(mainList);
    }
}
