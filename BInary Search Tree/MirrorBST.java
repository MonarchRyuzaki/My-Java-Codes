public class MirrorBST {
    static class Node{
        Node left;
        Node right;
        int data;
        Node (int data){
            this.data=data;
        }
    }
    public static Node createMirror(Node root){
        if (root == null){
            return null;
        }
        Node leftS = createMirror(root.left);
        Node rightS = createMirror(root.right);
        root.left = rightS;
        root.right = leftS;

        return root;
    }
    public static void preorder(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        /*
                    8
                   / \
                  5   10
                 / \    \
                3   6    11  
         */
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(11);
        preorder(root);
        System.out.println();
        /*
                    8
                   / \
                  10  5
                 /   / \
                11  6   3   
                Mirror BST
         */
        preorder(createMirror(root));
    }
}
