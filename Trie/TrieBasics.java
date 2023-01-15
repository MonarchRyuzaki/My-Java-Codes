public class TrieBasics{
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

    public static boolean search(String key){
        Node curr = root;
        for (int level=0;level<key.length();level++){
            int idx = key.charAt(level)-'a';
            if (curr.children[idx]==null){
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow==true;
    }
    public static void main(String[] args) {
        String []word = {"the","a","there","thier","any","thee"};
        for (int i = 0; i < word.length; i++) {
            insert(word[i]);
        }
        System.out.println(search("any")); //true
        System.out.println(search("an"));  //false
    }
}