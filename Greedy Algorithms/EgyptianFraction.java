public class EgyptianFraction {
    public static void findEF(int nr , int dr){
        if (nr == 0 || dr == 0){
            return;
        }
        if (dr % nr == 0){
            System.out.println("1/"+(dr/nr));
            return;
        }
        if (nr % dr == 0){
            System.out.println(nr/dr);
            return;
        }
        if (nr > dr){
            System.out.println((int)(nr/dr));
            findEF(nr%dr, dr);
            return;
        }

        int x = (dr/nr)+1;
        System.out.println("1/" +x);
        findEF(x*nr - dr, dr*x);
        return;
    }
    public static void main(String[] args) {
        findEF(12, 13);
    }
}
