public class KeypadCombinations {
    final static char alpha[][]= {{},
                           {},{'a','b','c'},{'d','e','f'},
                           {'g','h','i'},{'j','k','l'},{'m','n','o'},
                           {'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    public static void findCombinations(String digits,String ans,int len,int pos){
        if (len==0){
            System.out.println("");
        }
        else if (pos == len){
            System.out.println(ans);
            return;
        }
        char letters[] = alpha[Character.getNumericValue(digits.charAt(pos))];
        for (int i=0;i<letters.length;i++){
            ans = ans + letters[i];
            findCombinations(digits, ans , len, pos+1);
            ans = ans.substring(0,ans.length()-1);
        }
    }
    public static void main(String[] args) {
        String digits = "234";
        String ans="";
        findCombinations(digits, ans, digits.length(), 0);
    }
}