import java.util.Stack;

public class NextGreater {
    public static void printArray(int arr[]){
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        int matrix[] = {6, 8, 0, 1, 3};
        int nxtGrt[] = new int[matrix.length];

        for (int i=matrix.length-1; i>=0;i--){
            while (!s.isEmpty() && matrix[s.peek()]<=matrix[i]){
                s.pop();
            }
            if (s.isEmpty()){
                nxtGrt[i]=-1;
            } else {
                nxtGrt[i]=s.peek();
            }
            s.push(i);
        }
        printArray(nxtGrt);
    }
}
