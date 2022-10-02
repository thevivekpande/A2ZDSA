class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal)-atMost(nums, goal-1);
    }
    private int atMost(int[] nums, int Sum){
        if(Sum<0) return 0;
        int i=0, j=0, res=0, n=nums.length;
        for(;j<n;j++){
            Sum-=nums[j];
            while(Sum<0)
                Sum+=nums[i++];
            res+=j-i+1;
        }
        return res;
    }
}