class Solution {
    public int maxSubArray(int[] nums) {
        int res=Integer.MIN_VALUE, cur=0;
        for(int i:nums){
            cur+=i;
            res=Math.max(res, cur);
            if(cur<0)
                cur=0;
        }
        return res;
    }
}