class Solution {
    int findKRotation(int arr[], int n) {
        // code here
        int left=0, right=n-1;
        if(right==0 || arr[left]<arr[right]) return left;
        while(left<right){
            int mid=left+((right-left)>>1);
            if(mid>0 && arr[mid]<arr[mid-1]) return mid;
            if(mid+1<n && arr[mid+1]<arr[mid]) return mid+1;
            else if(arr[mid]>arr[left])
                left=mid+1;
            else right=mid-1;
        }
        return 0;
    }
}