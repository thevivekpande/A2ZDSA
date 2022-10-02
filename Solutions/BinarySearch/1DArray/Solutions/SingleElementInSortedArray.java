class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n=nums.length;
        int left=0, right=nums.length-1;
        
        while(left<=right){
            int mid=left+((right-left)>>1);
            
            if(mid%2==0){
                if(mid>0 && nums[mid]==nums[mid-1])
                    right=mid-1;
                else 
                    left=mid+1;
            }else{
                if(mid+1<n && nums[mid]==nums[mid+1])
                    right=mid-1;
                else
                    left=mid+1;
            }
        }
        
        return nums[right];
    }
}