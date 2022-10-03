class Solution {
    public int minCost(String colors, int[] neededTime) {
        int res=0;
        int l=0, r=0, n=neededTime.length;
        while(l<=r && r<n){
            l=r;
            int curTotal=0, curMax=neededTime[l];
            while(r<n && colors.charAt(l)==colors.charAt(r)){
                curTotal+=neededTime[r];
                curMax=Math.max(curMax, neededTime[r++]);
            }
            res+=curTotal-curMax;
        }
        return res;
    }
}