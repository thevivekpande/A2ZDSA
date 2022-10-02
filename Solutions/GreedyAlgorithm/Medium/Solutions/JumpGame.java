class Solution {
    public boolean canJump(int[] nums) {
        int max=0, i=0, n=nums.length;
        for(;i<n && max>=i; i++)
            max=Math.max(max, i+nums[i]);
        return i==n;
    }
}