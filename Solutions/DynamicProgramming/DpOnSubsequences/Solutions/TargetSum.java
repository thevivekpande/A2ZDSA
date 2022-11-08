class Solution {
    public int calculate(int[] nums, int i, int sum, int target, int total, int[][] dp){
        if(i==nums.length) return (sum==target)?1:0;
        if(dp[i][total+sum]!=-1000000) return dp[i][total+sum];
        int add=calculate(nums, i+1, sum+nums[i], target, total, dp);
        int subtract=calculate(nums, i+1, sum-nums[i], target, total, dp);
        return dp[i][total+sum]=add+subtract;
    }
    
    public int findTargetSumWays(int[] nums, int target) {
        int total=0;
        for(int i:nums) total+=i;
        int[][] dp=new int[nums.length][2*total +1];
        for(int[] row:dp)
            Arrays.fill(row, -1000000);
        return calculate(nums, 0, 0, target, total, dp);
    }
}