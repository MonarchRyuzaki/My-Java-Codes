import java.util.Stack;

public class ReverseString {
    public static void reverse(String str, Stack<Character> s,int index){
        if (index==str.length()){
            return;
        }
        char ch = str.charAt(index);
        s.push(ch);
        reverse(str,s,index+1);
    }
    public static void main(String[] args) {
        Stack<Character> s = new Stack<>();
        String str ="shivam";
        reverse(str, s, 0);
        while (!s.isEmpty()){
            System.out.print(s.pop());
        }
    }
}
