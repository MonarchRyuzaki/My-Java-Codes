import java.util.*;

public class BTOperations {
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
    public static int calcHeight(Node root){
        if (root==null){
            return 0;
        }
        int leftHeight = calcHeight(root.left);
        int rightHeight = calcHeight(root.right);
        return Math.max(leftHeight,rightHeight)+1;
    }
    public static int countNode(Node root){
        if (root==null){
            return 0;
        }
        int leftCount = countNode(root.left);
        int rightCount = countNode(root.right);
        return leftCount+rightCount+1;
    }
    public static int sumofNodes(Node root){
        if (root==null){
            return 0;
        }
        int leftSum = sumofNodes(root.left);
        int rightSum = sumofNodes(root.right);
        return leftSum+rightSum+root.data;
    }
    public static int findDiameter(Node root){
        if (root==null){
            return 0;
        }
        int leftDia = findDiameter(root.left);
        int rightDia = findDiameter(root.right);
        int leftHt = calcHeight(root.left);
        int rightHt = calcHeight(root.right);

        int selfDia = leftHt + rightHt + 1;

        return Math.max(selfDia , Math.max(leftDia, rightDia));
    }

    // static class Info {
    //     static int diameter;
    //     static int height;
    //     Info (int diameter , int height){
    //         this.diameter=diameter;
    //         this.height=height;
    //     }
    // }

    // public static Info diameter(Node root){
    //     if (root == null){
    //         return new Info(0, 0);
    //     }
    //     Info leftInfo = diameter(root.left);
    //     Info rightInfo = diameter(root.right);
    //     int diam = Math.max(Math.max(leftInfo.diameter, rightInfo.diameter), leftInfo.height+rightInfo.height+1);
    //     int ht = Math.max(leftInfo.height,rightInfo.height) + 1;

    //     return new Info (diam,ht);

    // }


    public static boolean isIdentical(Node node, Node subRoot){
        if (node == null && subRoot==null){
            return true;
        }
        if (node == null || subRoot == null || node.data!=subRoot.data){
            return false;
        }

        if (!isIdentical(node.left, subRoot.left)){
            return false;
        }

        if (!isIdentical(node.right, subRoot.right)){
            return false;
        }

        return true;
    }
    public static boolean isSubtree(Node root, Node subRoot){
        if (root==null){
            return false;
        }
        if (root.data == subRoot.data){
            if (isIdentical(root,subRoot)){
                return true;
            }
        }

        boolean leftAns = isSubtree(root.left, subRoot);
        boolean rightAns = isSubtree(root.right , subRoot);

        return leftAns || rightAns;
    }


    static class Info{
        Node node;
        int hd;
        public Info (Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node root){
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer,Node> map  = new HashMap<>();
        int min=0,max=0;
        q.add(new Info(root,0));
        q.add(null);

        while (!q.isEmpty()){
            Info curr = q.remove();
            if (curr == null){
                if (q.isEmpty()){
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if (!map.containsKey(curr.hd)){
                    map.put(curr.hd, curr.node);
                }
                if (curr.node.left !=null){
                    q.add(new Info (curr.node.left, curr.hd-1));
                    min = Math.min(min,curr.hd-1);
                }
                if (curr.node.right !=null){
                    q.add(new Info (curr.node.right, curr.hd+1));
                    max = Math.max(max,curr.hd+1);
                }

            }
        }
        for (int i = min ; i<=max ; i++){
            System.out.print(map.get(i).data+" ");
        }
        System.out.println();
    }
    

    public static void KthLevel(Node root, int level , int k){
        if (root==null){
            return;
        }
        if (level==k){
            System.out.print(root.data+" ");
            return;
        }
        KthLevel(root.left, level+1, k);
        KthLevel(root.right, level+1, k);
    }


    // public static boolean getPath(Node root, int n, ArrayList<Node> path){
    //     if (root==null){
    //         return false;
    //     }
    //     path.add(root);
    //     if (root.data == n){
    //         return true;
    //     }
    //     boolean foundLeft = getPath(root.left, n, path);
    //     boolean foundRight = getPath(root.right, n, path);
    //     if (foundLeft || foundRight){
    //         return true;
    //     }
    //     path.remove(path.size()-1);
    //     return false;
    // }
    public static Node lca(Node root, int n1, int n2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root,n1,path1);
        getPath(root,n2,path2);
        int i;
        for (i=0; i<path1.size() && i<path2.size();i++){
            if (!path1.get(i).equals(path2.get(i))){
                break;
            }
        }

        return path1.get(i-1);


    }
    

    public static Node lca2(Node root, int n1, int n2){
        if (root == null || root.data==n1 || root.data==n2){
            return root;
        }

        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        if (rightLca == null){
            return leftLca;
        }

        if (leftLca == null){
            return rightLca;
        }
        
        return root;
    }


    public static int getDist(Node root,int n){
        if (root == null){
            return -1;
        }

        if (root.data == n){
            return 0;
        }

        int leftDis = getDist(root.left, n);
        int rightDis = getDist(root.right, n);


        if (leftDis == -1 && rightDis == -1){
            return -1;
        } else if (leftDis == -1){
            return rightDis+1;
        } else if (rightDis == -1){
            return leftDis+1;
        }
        return -1;

    }
    public static int minDist(Node root, int n1, int n2){
        Node lca = lca2(root, n1, n2);

        int dist1 = getDist(lca,n1);
        int dist2 = getDist(lca,n2);

        return dist1+dist2;
    }

    public static boolean getPath(Node root, int n, ArrayList<Node> list){
        if (root==null){
            return false;
        }
        list.add(root);
        if (root.data == n){
            return true;
        }
        boolean foundLeft = getPath(root.left, n, list);
        boolean foundRight = getPath(root.right, n, list);
        if (foundLeft || foundRight){
            return true;
        }
        list.remove(list.size()-1);
        return false;
    }

    public static int KthLevelAncestor(Node root, int k, int n){
        ArrayList<Node> path = new ArrayList<>();
        getPath(root, n, path);
        for (int i=1;i<=k;i++){
            path.remove(path.size()-1);
        }
        return (path.get(path.size()-1).data);
    }

    public static int transform(Node root){
        if (root==null){
            return 0;
        }
        int leftChild= transform(root.left);
        int rightChild = transform(root.right);
        int data = root.data;

        int newLeft = (root.left == null) ? 0 : root.left.data;
        int newRight = (root.right == null) ? 0 : root.right.data;
        root.data = leftChild+newLeft+rightChild+newRight;
        return data;
    }

    public static void preorder(Node root){
        if (root==null){
            return;
        }

        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        /*
                    1
                   / \
                  2   3
                 / \ / \
                4  5 6  7   
        */
        BTOperations tree = new BTOperations();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        transform(root);
        preorder(root);
    }
}
