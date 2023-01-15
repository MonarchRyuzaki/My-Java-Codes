import java.util.Stack;

public class MaxAreaHistogram{
    public static int findmaxArea(int nums[]){
        int nsr[] = new int [nums.length];
        int nsl[] = new int [nums.length];
        int maxArea=0;
        Stack<Integer> s = new Stack<>();

        //Calculate Next Smaller Left
        for (int i=0;i<nums.length;i++){
            while (!s.isEmpty() && nums[s.peek()]>=nums[i]){
                s.pop();
            }
            if (s.isEmpty()){
                nsl[i]=-1;
            } else {
                nsl[i]=s.peek();
            }
            s.push(i);
        }

        //Calculate Next Smaller Right
        s = new Stack<>();
        for (int i=nums.length-1;i>=0;i--){
            while (!s.isEmpty() && nums[s.peek()]>=nums[i]){
                s.pop();
            }
            if (s.isEmpty()){
                nsr[i]=nums.length;
            } else {
                nsr[i]=s.peek();
            }
            s.push(i);
        }

        //Calculate Width
        for (int i=0;i<nums.length;i++){
            int height = nums[i];
            int width = nsr[i]-nsl[i]-1;
            int currArea = height*width;
            maxArea = Math.max(currArea,maxArea);
        }

        return maxArea;
    }
    public static void main(String[] args) {
        int height[] = {2,1,5,6,2,3};
        System.out.println(findmaxArea(height));
    }
}