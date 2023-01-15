import java.util.*;
public class Basics {
    public static void reverse (ArrayList<Integer> list){
        for (int i=list.size()-1 ; i>=0 ; i--){
            System.out.print(list.get(i)+" ");
        }
    }
    public static void maximum(ArrayList<Integer> list){
        int max=Integer.MIN_VALUE;
        for (int i = 0 ;i<list.size()-1;i++){
            max = Math.max (list.get(i),max);
        }
        System.out.println(max);
    }
    public static void swap(ArrayList<Integer> list){
        int idx1 = 1 , idx2 = 3;
        int temp = list.get (idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(3);
        list.add(6);
        System.out.println(list);
        swap(list);
        System.out.println(list);
    }
}
