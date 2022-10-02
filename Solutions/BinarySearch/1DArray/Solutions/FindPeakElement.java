// Recursive
class Solution {
    public int search(int[] nums, int left, int right){
        if(left>=right) return left;
        int mid=left+((right-left)>>1);
        if(nums[mid]>nums[mid+1])
            return search(nums, left, mid);
        return search(nums, mid+1, right);
    }
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        int left=0, right=n-1;
        return search(nums, left, right);
    }
}

// Iterative
class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        int left=0, right=n-1;
        while(left<right){
            int mid=left+((right-left)>>1);
            if(mid+1<n && nums[mid]>nums[mid+1])
                right=mid;
            else
                left=mid+1;
        }
        return left;
    }
}