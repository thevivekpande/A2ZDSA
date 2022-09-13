class Solution {
    public int maxProfit(int[] prices) {
        int res=0, minSoFar=prices[0];
        for(int i:prices){
            res=Math.max(res, i-minSoFar);
            minSoFar=Math.min(i, minSoFar);
        }
        return res;
    }
}