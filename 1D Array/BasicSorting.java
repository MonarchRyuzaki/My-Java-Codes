import java.util.*;
class BasicSorting
{
    public static void bubbleSort(int arr[])
    {
        int turns,j,swap=0,temp;
        for (turns=0;turns<=arr.length-2;turns++)       //runs n-1 times
        {
            for (j=0;j<arr.length-1-turns;j++)
            {
                if (arr[j]>arr[j+1])
                { 
                    //swap
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swap++;
                }
            }
        }
    }
    public static void selectionSort(int arr[])
    {
        int i,j,minPos,temp;
        for (i=0;i<=arr.length-2;i++)               //runs n-1 times
        {
            minPos=i;
            for (j=i+1;j<arr.length;j++)
            {
                if (arr[j]<arr[minPos])
                    minPos=j;
            }
            temp=arr[minPos];
            arr[minPos]=arr[i];
            arr[i]=temp;
        }
    }
    public static void insertionSort(int arr[])
    {
        int i,j,curr,prev;
        for (i=1;i<arr.length;i++)              //runs n-1 times
        {
            curr = arr[i];
            prev = i-1;
            while (prev >=0 && arr[prev]>curr)
            {
                arr[prev+1]=arr[prev];
                prev--;
            }
            arr[prev+1]=curr;
        }
    }
    public static void countingSort(int arr[])
    {
        int largest = Integer.MIN_VALUE;
        int i,j=0;
        for (i=0;i<arr.length;i++)
        {
            largest = Math.max(largest,arr[i]);
        }
        int count[] = new int [largest+1];
        for (i=0;i<arr.length;i++)
        {
            count[arr[i]]++;
        }
        for (i=0;i<count.length;i++)
        {
            while (count[i]>0)
            {
                arr[j]=i;
                j++;
                count[i]--;
            }
        }
    }
    public static void print(int arr[])
    {
        int i;
        for (i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String args[])
    {
        int arr[] = {1, 4, 1, 3, 2, 4, 3, 7};
        //insertionSort(arr);
        //Arrays.sort(arr, Collections.reverseOrder());
        countingSort(arr);
        print(arr);
    }
}