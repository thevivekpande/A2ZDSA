class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int[] pos=new int[n>>1];
        int[] neg=new int[n>>1];
        
        int c1=0, c2=0;
        for(int i:nums){
            if(i>0) pos[c1++]=i;
            else neg[c2++]=i;
        }
        
        for(int i=0;i<n;i+=2){
            nums[i]=pos[i>>1];
            nums[i+1]=neg[i>>1];
        }
        
        return nums;
    }
}