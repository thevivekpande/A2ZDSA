class Solution {
    public int findKthPositive(int[] arr, int k) {
        int left=0, right=arr.length;
        while(left<right){
            int mid=left+((right-left)>>1);
            if(arr[mid]<(k+mid+1))
                left=mid+1;
            else
                right=mid;
        }
        return left+k;
    }
}