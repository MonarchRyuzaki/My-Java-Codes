public class LongestWord {
    static class Node{
        Node children[] = new Node[26];
        boolean eow = false;
        Node(){
            for (int i=0 ;i<26;i++){
                children[i] = null;
            }
        }
    }
    public static Node root = new Node();
    public static void insert(String word){
        Node curr = root;
        for (int level=0;level<word.length();level++){
            char ch = word.charAt(level);
            int idx = ch -'a';
            if (curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            curr = curr.children[idx];
        }

        curr.eow=true;
    }

    static String ans = "";
    public static void findLongestWord(Node root,StringBuilder sb){
        if (root == null){
            return;
        }

        for (int i=0;i<26;i++){      // loop ko ulta karenge toh lexigographically longest ayega
            if (root.children[i] != null && root.children[i].eow==true){
                sb.append((char)(i+'a'));
                if (sb.length() > ans.length()){
                    ans = sb.toString();
                }
                findLongestWord(root.children[i],sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    public static void main(String[] args) {
        String words[] = {"a","banana","app","appl","ap","apply","apple"};
        for (int i=0;i<words.length;i++){
            insert(words[i]);
        }
        findLongestWord(root, new StringBuilder());
        System.out.println(ans);
    }
}
