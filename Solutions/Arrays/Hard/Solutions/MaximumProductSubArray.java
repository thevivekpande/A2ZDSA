class Solution {
    public int maxProduct(int[] nums) {
        int minVal=nums[0], maxVal=nums[0], maxProd=nums[0];
        int n=nums.length;
        for(int i=1;i<n;i++){
            if(nums[i]<0){
                int temp=minVal;
                minVal=maxVal;
                maxVal=temp;
            }
            minVal=Math.min(nums[i], nums[i]*minVal);
            maxVal=Math.max(nums[i], nums[i]*maxVal);
            maxProd=Math.max(maxProd, maxVal);
        }
        return maxProd;
    }
}