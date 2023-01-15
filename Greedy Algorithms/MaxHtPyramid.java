import java.util.*;

public class MaxHtPyramid{
    public static int maxHeight(int arr[]){
        int ht = 1;
        Arrays.sort(arr);
        int currCount = 1;
        int currWidth = arr[0];
        int width = 0;
        int count = 0;
        for (int i=1;i<arr.length;i++){
            width += arr[i];
            count += 1;
            if (width > currWidth && count > currCount){
                currWidth = width;
                currCount = count;

                width = 0;
                count = 0;

                ht++;
            }
        }

        return ht;
    }
    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 50, 60, 70};
        System.out.println(maxHeight(arr));
    }
}