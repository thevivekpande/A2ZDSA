class Solution {
    
    public static long pairWithMaxSum(long arr[], long N)
    {
        // Your code goes here
        long res=0, cur=0;
        for(int i=1;i<N;i++){
            res=Math.max(res, arr[i]+arr[i-1]);
        }
        return res;
    }
}