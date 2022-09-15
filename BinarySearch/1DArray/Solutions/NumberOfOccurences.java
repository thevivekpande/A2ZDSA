class Solution {
    int count(int[] nums, int n, int target) {
        // code here
        if(n==0 || nums[0]>target || nums[n-1]<target) return 0;
        int l=0, r=n-1;
        while(l<=r){
            int mid=l+((r-l)>>1);
            if(nums[mid]>=target)
                r=mid-1;
            else 
                l=mid+1;
        }
        
        if(nums[l]!=target) return 0;
        
        int first=l;
        r=n-1;
        
        while(l<=r){
            int mid=l+((r-l)>>1);
            if(nums[mid]==target)
                l=mid+1;
            else 
                r=mid-1;
        }
        
        return r-first+1;
        
    }
}