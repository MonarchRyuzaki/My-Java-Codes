public class GridWays {
    public static int findWays(int i,int j,int n, int m){
        //Base
        if (i==n-1 && j==m-1 ){//end
            return 1;
        } else if (i==n || j==m){//boundary
            return 0;
        }
        return (findWays(i+1, j, n, m)+findWays(i, j+1, n, m));

    }
    public static void main(String[] args) {
        int n= 3,m=3;
        System.out.println(findWays(0, 0, n, m));
    }
}
