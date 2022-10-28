// Recursion
public class Solution {
    private static int helper(int n, int[] heights){
        if(n==0) return 0;
        int left=helper(n-1, heights)+Math.abs(heights[n]-heights[n-1]);
        int right=Integer.MAX_VALUE;
        if(n>1)
            right=helper(n-2, heights)+Math.abs(heights[n]-heights[n-2]);
        return Math.min(left, right);
    }
    public static int frogJump(int n, int heights[]) {
        return helper(n-1, heights);
    }
}

// Memoization
public class Solution {
    private static int helper(int n, int[] heights, int[] dp){
        if(n==0) return 0;
        if(dp[n]!=-1) return dp[n];
        int left=helper(n-1, heights, dp)+Math.abs(heights[n]-heights[n-1]);
        int right=Integer.MAX_VALUE;
        if(n>1)
            right=helper(n-2, heights, dp)+Math.abs(heights[n]-heights[n-2]);
        return dp[n]=Math.min(left, right);
    }
    public static int frogJump(int n, int heights[]) {
        int[] dp=new int[n];
        Arrays.fill(dp, -1);
        return helper(n-1, heights, dp);
    }
}

// Top Down
public class Solution {
    public static int frogJump(int n, int heights[]) {
        int[] dp=new int[n];
        dp[1]=Math.abs(heights[1]-heights[0]);
        for(int i=2;i<n;i++){
            int left=Math.abs(heights[i]-heights[i-1])+dp[i-1];
            int right=Math.abs(heights[i]-heights[i-2])+dp[i-2];
            dp[i]=Math.min(left, right);
        }
        return dp[n-1];
    }
}