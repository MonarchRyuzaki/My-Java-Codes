public class test {
    public static void main(String[] args) {
        String s= "/a/b/../././c/../d";
        String p[] = s.split("/");
        for (int i=0;i<p.length;i++){
            System.out.println(p.length);
        }
    }
}
