import java.util.*;
class BasicSortingPractice
{
    public static void bubbleSort(int arr[])
    {
        int i,j,n=arr.length,temp;
        for (i=0;i<=n-2;i++)
        {
            for (j=0;j<n-1-i;j++)
            {
                if (arr[j]<arr[j+1])
                {
                    temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
    public static void selectionSort(int arr[])
    {
        int i,j,n=arr.length,temp,pos;
        for (i=0;i<=n-2;i++)
        {
            pos=i;
            for (j=i+1;j<n;j++)
            {
                if (arr[j]>arr[pos])
                    pos=j;
            }
            temp = arr[i];
            arr[i]=arr[pos];
            arr[pos]=temp;
        }
    }
    public static void insertionSort(int arr[])
    {
        int i,curr,prev,n=arr.length;;
        for (i=1;i<=n-1;i++)
        {
            curr=arr[i];
            prev=i-1;
            while (prev>=0 && arr[prev]<curr)
            {
                arr[prev+1]=arr[prev];
                prev--;
            }
            arr[prev+1]=curr;
        }
    }
    public static void countingSort(int arr[])
    {
        int largest=Integer.MIN_VALUE,i,j=0;
        for (i=0;i<arr.length;i++)
            largest=Math.max(largest,arr[i]);
        int count[]= new int[largest+1];
        for (i=0;i<arr.length;i++)
            count[arr[i]]++;
        for (i=0;i<count.length;i++)
        {
            while (count[i]>0)
            {
                arr[j]=i;
                j++;
                count[i]--;
            }
        }
        for (i=arr.length-1;i>=0;i--)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void print(int arr[])
    {
        int i;
        for (i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main (String args[])
    {
        int arr[] = {3, 6, 2, 1, 8, 7, 4, 5, 3 ,1};
        //bubbleSort(arr);
        //selectionSort(arr);
        //insertionSort(arr);
        //print(arr);
        countingSort(arr);
    }
}