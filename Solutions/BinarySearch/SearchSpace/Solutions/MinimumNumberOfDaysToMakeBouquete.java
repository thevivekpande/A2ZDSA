class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int left=0, right=0;
        
        if(m*k>bloomDay.length) return -1;
        for(int i:bloomDay){
            left=Math.min(i, left);
            right=Math.max(i, right);
        }
        
        while(left<=right){
            int mid=left+((right-left)>>1);
            boolean isPos=isPossible(bloomDay, m, k, mid);
            if(isPos)
                right=mid-1;
            else
                left=mid+1;
        }
        
        return left;
    }
    
    private boolean isPossible(int[] arr, int m, int k, int mid){
        int count=0, cur=0;
        for(int i:arr){
            if(i<=mid)
                cur++;
            else cur=0;
            
            if(cur==k){
                count++;
                cur=0;
            }
        }
        return count>=m;
    }
}