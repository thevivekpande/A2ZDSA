class Solution
{
    void leftRotate(long arr[], int k,int n)
    {
        if(n==0 || k==0 || k%n==0) return;
        k%=n;
        reverse(arr, 0, k-1);
        reverse(arr, k, n-1);
        reverse(arr, 0, n-1);
    }
    
    void reverse(long[] arr, int left, int right){
        while(left<right){
            long temp=arr[left];
            arr[left++]=arr[right];
            arr[right--]=temp;
        }
    }
}

