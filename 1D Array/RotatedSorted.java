import java.util.*;
class RotatedSorted
{
    public static int search(int nums[],int target)
    {
        int low=0,high = nums.length-1,mid,pos=0;boolean found = false;
        while (low<=high)
        {
            mid = (low+high)/2;
            if (nums[mid]==target)
            {
                pos = mid;
                found = true;
            }
            if (nums[low]<nums[mid])
            {
                if (target>=nums[low] && target<nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            else
            {
                if (nums[mid]<target && target<=nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        if (found == true)
            return pos;
        else
            pos = -1;
        return pos;
    }
    public static void main(String args[])
    {
        int nums[] = {4, 5, 6, 7, 0, 1, 2};
        int target;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value to be searched");
        target = sc.nextInt();
        int output=search(nums,target);
        System.out.println(output);
    }
}