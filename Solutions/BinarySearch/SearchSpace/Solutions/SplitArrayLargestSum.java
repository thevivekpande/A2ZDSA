class Solution {
    public int splitArray(int[] nums, int m) {
        int left=0, right=0;
        for(int n:nums){
            left=Math.max(n, left);
            right+=n;
        }
        while(left<=right){
            int mid=left+((right-left)>>1);
            boolean isPos=isPossible(nums ,mid ,m);
            if(isPos)
                right=mid-1;
            else
                left=mid+1;
        }
        return left;
    }
    
    private boolean isPossible(int[] nums, int mid, int limit){
        int count=1, cur=0;
        for(int n:nums){
            if(cur+n<=mid)
                cur+=n;
            else{
                cur=n;
                count++;
            }
            if(count>limit) return false;
        }
        return count<=limit;
    }
}