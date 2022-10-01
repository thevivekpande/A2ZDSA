class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        if(n==1) return 0;
        if(nums[0]==0) return -1;
        int res=1, maxReach=nums[0], steps=nums[0];
        for(int i=1;i<n;i++){
            if(i==n-1) return res;
            maxReach=Math.max(maxReach, i+nums[i]);
            steps--;
            if(steps==0){
                res++;
                if(maxReach<=i)
                    return -1;
                steps=maxReach-i;
            }
        }
        return -1;
    }
}