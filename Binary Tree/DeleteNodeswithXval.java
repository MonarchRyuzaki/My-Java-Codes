public class DeleteNodeswithXval {
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

    public static Node delNode(Node root , int x){
        if (root == null){
            return null;
        }
        root.left = delNode(root.left, x);
        root.right = delNode(root.right, x);
        if (root.data == x && root.left==null && root.right == null){
            return null;
        }
        return root;
    }
    static void inorder(Node root) 
    { 
        if (root == null) 
            return; 
        inorder(root.left); 
        System.out.print(root.data + " "); 
        inorder(root.right); 
    } 
    public static void main(String[] args) {
        /*
                    10
                   / \
                  3   10
                 / \    \
                3  1     3
                       /   \ 
                      3     3
        */
        Node root = new Node(10); 
        root.left = new Node(3); 
        root.right = new Node(10); 
        root.left.left = new Node(3); 
        root.left.right = new Node(1); 
        root.right.right = new Node(3); 
        root.right.right.left = new Node(3); 
        root.right.right.right = new Node(3);
        inorder(root);
        System.out.println();
        delNode(root, 3);
        inorder(root);
    }
}
