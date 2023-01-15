public class DeleteLeafNodes{
    static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
            this.right=null;
            this.left=null;
        }
    }
    public static void delNodes(Node node,int x){
        if (node.left.data==x){
            node.left=null;
            return;
        }
        if (node.right.data==x){
            node.right=null;
            return;
        }
        
    }
}