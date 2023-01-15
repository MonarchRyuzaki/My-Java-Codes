class DividenConquer
{
    public static void printArr(String arr[])
    {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] +" ");
        }
        System.out.println();
    }
    public static void mergeSort(String arr[], int si , int ei)
    {
        if (si>=ei)
        {
            return;
        }
        int mid = si+(ei-si)/2;
        mergeSort(arr,si,mid);//left
        mergeSort(arr,mid+1,ei);//right
        mergeString(arr,si,mid,ei);
    }
    public static void merge(int arr[],int si, int mid , int ei)
    {
        int temp[] = new int [ei-si+1];
        int i = si; //left index
        int j = mid+1;//right index
        int k = 0;//temp index
        while (i<=mid && j<=ei)
        {
            if (arr[i]<arr[j])
            {
                temp[k]=arr[i];
                i++;
            }
            else
            {
                temp[k]=arr[j];
                j++;
            }
            k++;
        }
        while (i<=mid)
            temp[k++]=arr[i++];
        while (j<=ei)
        temp[k++]=arr[j++];
        for (k=0,i=si;k<temp.length;k++,i++)
        {
            arr[i]=temp[k];
        }
    }
    public static void mergeString(String arr[],int si, int mid , int ei)
    {
        String temp[] = new String [ei-si+1];
        int i = si; //left index
        int j = mid+1;//right index
        int k = 0;//temp index
        while (i<=mid && j<=ei)
        {
            if (arr[i].compareTo(arr[j])<0)
            {
                temp[k]=arr[i];
                i++;
            }
            else
            {
                temp[k]=arr[j];
                j++;
            }
            k++;
        }
        while (i<=mid)
            temp[k++]=arr[i++];
        while (j<=ei)
        temp[k++]=arr[j++];
        for (k=0,i=si;k<temp.length;k++,i++)
        {
            arr[i]=temp[k];
        }
    }
    public static void QuickSort(int arr[],int si ,int ei)
    {
        if (si>=ei)
            return;
        int pInx = partition(arr,si,ei);
        QuickSort(arr, si, pInx-1);//left
        QuickSort(arr, pInx, ei);//right
    }
    public static int partition(int arr[] ,int si , int ei)
    {
        int j, i =si-1,pivot=arr[ei];
        for (j=si;j<ei;j++)
        {
            if (arr[j]<=pivot)
            {
                i++;
                int temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        return i;
    }
    public static void main (String args[])
    {
        String arr[] = { "sun", "earth", "mars", "mercury"};
        mergeSort(arr,0,arr.length-1);
        printArr(arr);
        //majorityElement(arr);
    }
}