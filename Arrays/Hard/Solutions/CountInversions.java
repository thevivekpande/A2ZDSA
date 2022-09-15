class Solution
{
    static long merge(long[] arr, long[] temp, int start, int mid, int last){
        long res=0;
        int i=start, j=mid, k=start;
        while(i<mid && j<=last){
            if(arr[i]<=arr[j]){
                temp[k++]=arr[i++];
            }else{
                res+=mid-i;
                temp[k++]=arr[j++];
            }
        }
        
        while(i<mid) temp[k++]=arr[i++];
        while(j<=last) temp[k++]=arr[j++];
        
        for(i=start;i<=last;i++)
            arr[i]=temp[i];
        
        return res;
    }
    static long mergeSort(long[] arr, long[] temp, int start, int last){
        long res=0;
        if(start<last){
            int mid=start+((last-start)>>1);
            res+=mergeSort(arr, temp, start, mid);
            res+=mergeSort(arr, temp, mid+1, last);
            res+=merge(arr, temp, start, mid+1, last);
        }
        return res;
    }
    
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        int n=arr.length;
        long[] temp=new long[n];
        return mergeSort(arr, temp, 0, n-1);
    }
}