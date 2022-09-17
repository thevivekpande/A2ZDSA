class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left=0, right=0;
        for(int w:weights){
            right+=w;
            left=Math.max(left, w);
        }
        while(left<right){
            int mid=left+((right-left)>>1);
            boolean isPos=isPossible(weights, mid, days);
            if(isPos)
                right=mid;
            else
                left=mid+1;
        }
        return left;
    }
    private boolean isPossible(int[] weights, int mid, int days){
        int count=1, cur=0;
        for(int w:weights){
            if(cur+w<=mid)
                cur+=w;
            else{
                cur=w;
                count++;
            }
            if(count>days) return false;
        }
        return count<=days;
    }
}