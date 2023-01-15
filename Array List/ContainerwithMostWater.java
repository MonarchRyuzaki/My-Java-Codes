import java.util.ArrayList;
public class ContainerwithMostWater {
    public static int mostArea(int nums[]){ //(O(n^2))
        int max = Integer.MIN_VALUE;
        int i,j,width,area;
        for (i=0;i<nums.length;i++){
            for (j=i+1;j<nums.length;j++){
                width = Math.abs(i-j);
                area = width*Math.min(nums[i],nums[j]);
                max = Math.max(max,area);
            }
        }
        return max;
    }
    public static int mostArea2P (ArrayList<Integer> nums){ // O(n)
        int leftPoint = 0 ;
        int rightPoint = nums.size()-1;
        int width=0 , max=Integer.MIN_VALUE , area=0;
        while (leftPoint<rightPoint){
            width = rightPoint - leftPoint;
            area = width*Math.min(nums.get(leftPoint),nums.get(rightPoint));
            max = Math.max(area,max);
            if (nums.get(leftPoint)<nums.get(rightPoint))
                leftPoint++;
            else
                rightPoint--;
        }
        return max;
    }
    public static void main(String[] args) {
        int hei[] = {1,8,6,2,5,4,8,3,7};
        //System.out.println(mostArea(hei));
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        System.out.println(mostArea2P(height));
    }
}