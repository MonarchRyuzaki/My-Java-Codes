import java.util.*;

public class LexiShortestString {
    public static void main(String[] args) {
        int k=42,n=5;
        char arr[] = new char[n];
 
        Arrays.fill(arr, 'a');
 
        // Iteration from the last position
        // in the array
        for (int i = n - 1; i >= 0; i--) {
 
            k -= i;
 
            // If k is a positive integer
            if (k >= 0) {
 
                // 'z' needs to be inserted
                if (k >= 26) {
                    arr[i] = 'z';
                    k -= 26;
                }
 
                // Add the required character
                else {
                    arr[i] = (char)(k + 97 - 1);
                    k -= arr[i] - 'a' + 1;
                }
            }
 
            else
                break;
 
            k += i;
        }
 
        System.out.println(new String(arr));
    }
}
