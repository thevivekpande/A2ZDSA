class Solution {
    public int findMin(int[] nums) {
        int left=0, right=nums.length-1;
        if(right==0 || nums[left]<nums[right]) return nums[left];
        while(left<right){
            int mid=left+((right-left)>>1);
            if(nums[mid]>nums[mid+1]) return nums[mid+1];
            if(nums[mid-1]>nums[mid]) return nums[mid];
            else if(nums[left]<nums[mid])
                left=mid+1;
            else
                right=mid-1;
        }
        return nums[left];
    }
}