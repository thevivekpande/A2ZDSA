// Recursion
class Solution{
    private static int helper(int ind, int W, int[] val, int[] wt){
        if(ind==0){
            return val[ind] * (W/wt[ind]);
        }
        
        int notTake=helper(ind-1, W, val, wt);
        int take=0;
        if(W>=wt[ind])
            take=val[ind]+helper(ind, W-wt[ind], val, wt);
        
        return Math.max(take, notTake);
    }
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        return helper(N-1, W, val, wt);
    }
}

// Memoization
class Solution{
    private static int helper(int ind, int W, int[] val, int[] wt, int[][] dp){
        if(ind==0){
            return val[ind] * (W/wt[ind]);
        }
        
        if(dp[ind][W]!=0) return dp[ind][W];
        
        int notTake=helper(ind-1, W, val, wt, dp);
        int take=0;
        if(W>=wt[ind])
            take=val[ind]+helper(ind, W-wt[ind], val, wt, dp);
        
        return dp[ind][W]=Math.max(take, notTake);
    }
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        int[][] dp=new int[N+1][W+1];
        return helper(N-1, W, val, wt, dp);
    }
}

// Tabulation

//User function Template for Java

class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        int[][] dp=new int[N+1][W+1];
        for(int i=0;i<=W;i++) dp[0][i]=val[0]*(i/wt[0]);
        
        for(int i=1;i<N;i++){
            for(int j=0;j<=W;j++){
                int notTake=dp[i-1][j];
                int take=0;
                if(j>=wt[i])
                    take=val[i]+dp[i][j-wt[i]];
                dp[i][j]=Math.max(take, notTake);
            }
        }
        
        return dp[N-1][W];
    }
}