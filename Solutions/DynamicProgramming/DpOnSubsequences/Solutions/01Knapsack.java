// Recursion
class Solution 
{ 
    private static int helper(int i, int W, int[] wt, int[] val){
        if(i==0){
            if(W>=wt[i]) return val[i];
            return 0;
        }
        int notPick=helper(i-1, W, wt, val);
        int pick=Integer.MIN_VALUE;
        if(W>=wt[i]) pick=val[i]+helper(i-1, W-wt[i], wt, val);
        return Math.max(pick, notPick);
    }
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         for(int[] row:dp)
            Arrays.fill(row, -1);
         return helper(n-1, W, wt, val, dp);
    } 
}


// Memoization
class Solution 
{ 
    private static int helper(int i, int W, int[] wt, int[] val, int[][] dp){
        if(i==0){
            if(W>=wt[i]) return val[i];
            return 0;
        }
        if(dp[i][W]!=-1) return dp[i][W];
        int notPick=helper(i-1, W, wt, val, dp);
        int pick=Integer.MIN_VALUE;
        if(W>=wt[i]) pick=val[i]+helper(i-1, W-wt[i], wt, val, dp);
        return dp[i][W]=Math.max(pick, notPick);
    }
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         for(int[] row:dp)
            Arrays.fill(row, -1);
         return helper(n-1, W, wt, val, dp);
    } 
}


// Tabulation

class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         int[][] dp=new int[n][W+1];
         for(int i=wt[0];i<=W;i++) dp[0][i]=val[0];
         for(int i=1;i<n;i++){
             for(int j=0;j<=W;j++){
                 int notPick=dp[i-1][j];
                 int pick=Integer.MIN_VALUE;
                 if(j>=wt[i]) pick=val[i]+dp[i-1][j-wt[i]];
                 dp[i][j]=Math.max(pick, notPick);
             }
         }
         return dp[n-1][W];
    } 
}
