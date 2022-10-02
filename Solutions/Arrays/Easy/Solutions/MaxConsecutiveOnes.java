class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int curr=0, res=0;
        for(int i:nums){
            if(i==1){
                curr++;
            }else{
                res=Math.max(res, curr);
                curr=0;
            }
        }
        res=Math.max(res, curr);
        return res;
    }
}