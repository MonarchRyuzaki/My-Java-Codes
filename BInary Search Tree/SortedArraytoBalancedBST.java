import java.util.*;

public class SortedArraytoBalancedBST {
    static class Node{
        Node left;
        Node right;
        int data;
        Node (int data){
            this.data=data;
        }
    }
    public static Node convert(int arr[], Node root, int lb, int ub){
        if (lb>ub){
            return null;
        }
        int mid = (lb+ub)/2;
        root = new Node(arr[mid]);
        root.left = convert(arr, root.left, lb, mid-1);
        root.right = convert(arr, root.right, mid+1, ub);
        return root;
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
        int arr[] = {3, 5, 6, 8, 10, 11, 12};
        Node root = convert(arr, null, 0, arr.length-1);
        levelOrder(root);
    }
}