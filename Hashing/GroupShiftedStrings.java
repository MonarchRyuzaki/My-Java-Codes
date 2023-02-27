import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class GroupShiftedStrings {

    static int alpha = 26;
    public static String getDiffString(String str){
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<str.length()-1;i++){
            int k = ((int)(str.charAt(i+1)-str.charAt(i))); 
            if (k < 0){
                k += alpha;
            }
            sb.append(k+"a");
        }
        return sb.toString();
    }
    public static void grpShiftedStrings(String str[]){
        HashMap<String , ArrayList<Integer>> map = new HashMap<>();
        for (int i=0;i<str.length;i++){
            String diff = getDiffString(str[i]);
            ArrayList<Integer> idx = map.getOrDefault(diff, new ArrayList<>());
            idx.add(i);
            map.put(diff,idx);
        }

        for (String i : map.keySet()){
            ArrayList<Integer> v = map.get(i);
            for (int j=0;j<v.size();j++){
                System.out.print(str[v.get(j)] +" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        String str[] = {"acd", "dfg", "wyz", "yab", "mop",
        "bdfh", "a", "x", "moqs"};
        grpShiftedStrings(str);
    }
}
