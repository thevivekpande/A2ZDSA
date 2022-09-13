class Solution {
    public boolean searchMatrix(int[][] nums, int target) {
        int rows=nums.length, cols=nums[0].length-1;
        int left=0, right=rows-1;
        while(left<=right){
            int mid=left+((right-left)>>1);
            if(nums[mid][0]<=target && nums[mid][cols]>=target){
                return helper(nums, mid, target);
            }else if(nums[mid][cols]<target){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return false;
    }
    private boolean helper(int[][] nums, int row, int target){
        int left=0, right=nums[0].length-1;
        while(left<=right){
            int mid=left+((right-left)>>1);
            if(nums[row][mid]==target) return true;
            else if(nums[row][mid]<target) left=mid+1;
            else right=mid-1;
        }
        return false;
    }
}