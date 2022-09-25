class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k)-atMost(nums, k-1);
       }
    private int atMost(int[] nums, int k){
         int res=0, i=0, j=0, n=nums.length;
        for(;j<n;j++){
            k-=nums[j]%2==1?1:0;
            while(k<0)
                k+=nums[i++]%2==1?1:0;
            res+=j-i+1;
        }
        return res;
    }
}