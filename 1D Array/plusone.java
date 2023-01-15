class Solution {
    public int[] plusOne(int[] digits) {
        int i=digits.length-1;int newArr[] = new int [digits.length+1];
        digits[i]++;boolean f = false;
        if (digits[0]==9)
        {
            newArr[0]=1;
            for (i=1;i<newArr.length;i++)
            {
                newArr[i]=0;
            }
            return newArr;
        }
        if (i>1)
        {
            i=digits.length-1;
            if ((digits[digits.length-1]==10)&&(i>=0)&&(digits[i-1]!=9)&&(digits[0]!=9))
            {
                digits[i-1]++;
                digits[i]=0;
                f=true;
            }
            while ((digits[i]==10)&&(digits[i-1]<=9)&&(i>=0)&&(digits[0]!=9)&&(f=false))
            {
                digits[i]=0;
                digits[i-1]++;
                i--;
            }
        }
        return digits;
    }
}