import java.util.Stack;

public class ValidParenthesis {
    public static boolean checkParenthesis(String str){
        int i;
        char ch;
        Stack<Character> s = new Stack<>();
        for (i=0;i<str.length();i++){
            ch = str.charAt(i);
            if (ch=='(' || ch=='{' || ch=='['){
                s.push(ch);
            } else {
                if (s.isEmpty()){
                    return false;
                }
                char top = s.peek();
                if((top == '(' && ch == ')') || (top == '{' && ch == '}')|| (top == '[' && ch == ']')) {
                    s.pop();
                } else {
                    return false;
                }
            }
        }
        if (s.isEmpty()){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(checkParenthesis("()[]{}[{()}()]"));
    }
}
