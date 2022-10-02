class Solution {
    public long countSubarrays(int[] nums, long k) {
        long res=0;
        int n=nums.length, i=0, j=0;
        long sum=0;
        for(;j<n;j++){
            sum+=nums[j];
            while(sum*(j-i+1)>=k)
                sum-=nums[i++];
            res+=j-i+1;
        }
        return res;
    }
}