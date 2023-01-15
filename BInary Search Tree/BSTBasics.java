import java.util.*;

public class BSTBasics{
    static class Node{
        Node left;
        Node right;
        int data;
        Node (int data){
            this.data=data;
        }
    }

    public static Node insert(Node root, int val){
        if (root == null){
            root = new Node(val);
            return root;
        }
        if (root.data<val){
            root.right = insert(root.right , val);
        } else {
            root.left = insert(root.left, val);
        }
        return root;
    }
    public static void inorder(Node root){
        if (root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static boolean searchBST(Node root, int key){
        if (root == null){
            return false;
        }

        if (root.data<key){
            searchBST(root.right, key);
        }

        if (root.data>key){
            searchBST(root.left, key);
        }

        if (root.data == key){
            return true;
        }
        return false;
    }

    public static Node delete(Node root , int val){
        if (root.data<val){
            root.right = delete(root.right,val);
        } else if (root.data>val){
            root.left = delete(root.left, val);
        } else {
            //case 1 - no child node
            if (root.left == null && root.right == null){
                return null;
            }

            //case 2 - 1 child
            if (root.left == null){
                return root.right;
            } else if (root.right == null){
                return root.left;
            }


            //case 3 - 2 child
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete (root.right , IS.data);
        }
        return root;
    }

    public static Node findInorderSuccessor(Node root){
        while (root.left!=null){
            root=root.left;
        }
        return root;
    }

    public static void printPath(ArrayList<Integer> path){
        for (int i=0;i<path.size();i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.println("Null");
    }
    public static void getPathRoot2Leaf(Node root, ArrayList<Integer> path){
        if (root == null){
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null){
            printPath(path);
        }
        getPathRoot2Leaf(root.left, path);
        getPathRoot2Leaf(root.right, path);
        path.remove(path.size()-1);
    }

    public static boolean isValidBST(Node root, Node min, Node max){
        if (root == null){
            return true;
        }
        if (min != null && root.data<=min.data){
            return false;
        }
        else if (max != null && root.data>=max.data){
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
    public static void main(String[] args) {
        int arr[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;
        for (int i=0;i<arr.length;i++){
            root = insert(root,arr[i]);
        }    
        System.out.println(isValidBST(root, null, null));
    }
}