import java.util.*;
class DSASheetQ12 {
    public int[] productExceptSelf(int[] nums) {
        int i,n = nums.length;
        int answer [] = new int [n];
        int prefix[] = new int [n];
        int suffix[] = new int [n];
        prefix[0]=1;suffix[n-1]=1;
        for (i=1;i<n;i++)
        {
            prefix[i]=prefix[i-1]*nums[i-1];
        }
        for (i=n-2;i>=0;i--)
        {
            suffix[i]=suffix[i+1]*nums[i+1];
        }
        for (i=0;i<n;i++)
        {
            answer[i]=prefix[i]*suffix[i];
        }
        return answer;
        }
    }
