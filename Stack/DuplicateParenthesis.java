import java.util.Stack;

public class DuplicateParenthesis {
    public static boolean checkDuplicate(String str){
        Stack<Character> s = new Stack<>();
        int i,count=0;
        
        for (i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if (ch==')'){
                count=0;
                while (s.peek()!='('){
                    s.pop();
                    count++;
                }
                if (count<1){
                    return true;
                }
            } else {
                s.push(ch);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String str1 = "((a+b)+(c))";
        System.out.println(checkDuplicate(str1));
    }
}
