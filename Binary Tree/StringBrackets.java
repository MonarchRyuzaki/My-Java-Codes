import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StringBrackets{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    static int start = 0;
    public static Node constructTree(String s){
        if (s.length ()== 0 || s==null){
            return null;
        }
        if (start>=s.length()){
            return null;
        }

        boolean neg = false;
        
        if (s.charAt(start) == '-'){
            neg = true;
            start++;
        }

        int num = 0;
        while (start<=s.length() && Character.isDigit(s.charAt(start))){
            int digit = Character.getNumericValue(s.charAt(start));
            num = 10*num + digit;
            start++;
        }

        if (neg){
            num = -num;
        }

        Node node = new Node(num);

        if (start>=s.length()){
            return node;
        }

        if (start<s.length() && s.charAt(start)=='('){
            start++;
            node.left = constructTree(s);
        }
        if (start<s.length() && s.charAt(start)==')'){
            start++;
            return node;
        }
        if (start<s.length() && s.charAt(start)=='('){
            start++;
            node.right = constructTree(s);
        }
        if (start<s.length() && s.charAt(start)==')'){
            start++;
            return node;
        }
        return node;
    }

    public static void levelOrder(Node root){
        if (root==null){
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()){
            Node currNode = q.remove();
            if (currNode==null){
                System.out.println();
                if (q.isEmpty()){
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data+" ");
                if (currNode.left != null){
                    q.add(currNode.left);
                }
                if (currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }
    }
    public static void main(String[] args) {
        String str = "4(2(3)(1))(6(5))";
        Node root = constructTree(str);
        levelOrder(root);
    }
}