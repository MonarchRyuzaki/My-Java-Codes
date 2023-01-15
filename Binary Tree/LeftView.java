import java.util.*;

public class LeftView {
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
    static ArrayList<Integer> list = new ArrayList<>();
    public static void leftView(Node root) {
      ArrayList<Integer> list = new ArrayList<>();
      Queue<Node> q = new LinkedList<>();
      int count = 0;
      q.add(root);
      q.add(null);
      list.add(root.data);
      while (!q.isEmpty()){
          Node currNode = q.remove();
          if (currNode == null){
              if (q.isEmpty()){
                  break;
              } else {
                  count = 0;
                  q.add(null);
              }
          } else {
              if (count == 1){
                  list.add(currNode.data);
              }
              if (root.left!=null){
                  q.add(root.left);
              } 
              if (root.right != null){
                  q.add(root.right);
              }
              count ++;
          }
      }
    }
    public static void printlist(){
        for (int i=0 ;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        leftView(root);
        printlist();
    }
}
