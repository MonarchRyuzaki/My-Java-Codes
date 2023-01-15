import java.util.*;

public class mergeBST {
    static class Node{
        Node left;
        Node right;
        int data;
        Node (int data){
            this.data=data;
        }
    }
    public static void getInorder(ArrayList<Integer> list1 , Node root){
        if (root == null){
            return;
        }
        getInorder(list1, root.left);
        list1.add(root.data);
        getInorder(list1, root.right);
    }
    public static Node constructBST(ArrayList<Integer> list, Node root, int lb, int ub){
        if (lb>ub){
            return null;
        }
        int mid = (lb+ub)/2;
        root = new Node(list.get(mid));
        root.left = constructBST(list, root.left, lb, mid-1);
        root.right = constructBST(list, root.right, mid+1, ub);
        return root;
    }
    public static Node merge(Node root1 , Node root2){
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        getInorder(list1, root1);
        getInorder(list2, root2);


        ArrayList<Integer> list = new ArrayList<>();
        int p1=0,p2=0;


        while (p1<list1.size() && p2<list2.size()){
            if (list1.get(p1)<list2.get(p2)){
                list.add(list1.get(p1++));
            } else {
                list.add(list2.get(p2++));
            }
        }


        while (p1<list1.size()){
            list.add(list1.get(p1++)); 
        }


        while (p2<list2.size()){
            list.add(list2.get(p2++)); 
        }

        return constructBST(list, null , 0, list.size()-1);
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
        /*     
                  2     
                 / \    
                1   4   
                BST1
         */
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);
        
        /*     
                  9    
                 / \    
                3   12   
                BST2
         */
        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        /* 2 possible expected balanced BSTs can be formed
                     4
                    /  \ 
                   2    9
                  / \    \
                 1   3   12 
            
                      3
                    /   \ 
                   1      9
                    \    / \
                     2  4  12 
                final ans is our 2nd BST
        */

        Node root = merge(root1, root2);
        levelOrder(root);
    }
}