import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MinSwaps {

    public static void inorder(ArrayList<Integer> v, int index , int n,int arr[]){

        if (index>=n){
            return;
        }
        inorder(v, 2*index+1, n,arr);
        v.add(arr[index]);
        inorder(v,2*index+2,n,arr);
    }

    public static void swap(ArrayList<Integer> v, int  x, int y){
        int temp = v.get(x);
        v.set(x,v.get(y));
        v.set(y,temp);
    }
    public static void main(String[] args) {
        
        int arr[] = { 5, 6, 7, 8, 9, 10, 11 };
        ArrayList<Integer> inorder = new ArrayList<>();
        inorder(inorder,0,arr.length,arr);
        HashMap<Integer,Integer> map = new HashMap<>();
        int temp[] = Arrays.copyOfRange(arr, 0,arr.length);
        Arrays.sort(temp);

        int ans = 0;
        for (int i=0;i<inorder.size();i++){
            map.put(inorder.get(i),i);
        }

        for (int i=0;i<inorder.size();i++){
            
            if (inorder.get(i) != temp[i]){
                ans++;
                int tem = inorder.get(i);

                swap(inorder,i,map.get(temp[i]));


                map.put(tem,map.get(temp[i]));
                map.put(temp[i],i);
                

            }
        }
        System.out.println(ans);
    }
}
