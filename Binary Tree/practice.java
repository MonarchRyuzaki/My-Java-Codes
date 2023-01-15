import java.util.*;

public class practice {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void levelOrderTraversal(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()){
            Node currNode = q.remove();
            if (currNode == null){
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

    public static int heightofTree (Node root){
        if (root == null){
            return 0;
        }
        int leftHt = heightofTree(root.left);
        int rightHt = heightofTree(root.right);
        int x = (leftHt<rightHt) ? rightHt : leftHt;
        return x+1;
    }

    static int count = 0;
    public static void countNode(Node root){
        if (root == null){
            return;
        }
        count++;
        countNode(root.left);
        countNode(root.right);
        return;
    }

    public static int sumofNodes(Node root){
        if (root==null){
            return 0;
        }
        int leftSum = sumofNodes(root.left);
        int rightSum = sumofNodes(root.right);
        return leftSum+rightSum+root.data;
    }

    public static int diameter(Node root){
        if (root==null){
            return 0;
        }

        int leftDia = diameter(root.left);
        int leftHt = heightofTree(root.left);
        int rightDia = diameter(root.right);
        int rightHt = heightofTree(root.right);

        int selfDia = leftHt + rightHt + 1;

        return Math.max(selfDia , Math.max(leftDia,rightDia));
    }

    
    public static void main(String[] args) {
        /*
                    1
                   / \
                  2   3
                 / \ / \
                4  5 6  7   
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(diameter(root));
    }
}
