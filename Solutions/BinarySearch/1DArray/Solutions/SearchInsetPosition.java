class Solution {
    public int searchInsert(int[] nums, int target) {
        int low=0, high=nums.length-1;
        if(nums[high]<target) return high+1;
        while(low<high){
            int mid=low+((high-low)>>1);
            if(nums[mid]>=target)
                high=mid;
            else 
                low=mid+1;
        }
        return low;
    }
}