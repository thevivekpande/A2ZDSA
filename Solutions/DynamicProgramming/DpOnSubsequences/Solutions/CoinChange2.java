// Recursion
class Solution {
    private long helper(int[] coins, int ind, int sum){
        if(ind==0){
            if(sum%coins[ind]==0) return 1;
            return 0;
        }
        
        long notTake=helper(coins, ind-1, sum);
        long take=0;
        if(sum>=coins[ind]) take=helper(coins, ind, sum-coins[ind]);
        return take+notTake;
    }
    
    public long count(int coins[], int N, int sum) {
        // code here.
        return helper(coins, N-1, sum);
    }
}

// Memoization
class Solution {
    private long helper(int[] coins, int ind, int sum, long[][] dp){
        if(ind==0){
            if(sum%coins[ind]==0) return 1;
            return 0;
        }
        
        if(dp[ind][sum]!=0) return dp[ind][sum];
        
        long notTake=helper(coins, ind-1, sum, dp);
        long take=0;
        if(sum>=coins[ind]) take=helper(coins, ind, sum-coins[ind], dp);
        return dp[ind][sum]=take+notTake;
    }
    
    public long count(int coins[], int N, int sum) {
        // code here.
        long[][] dp=new long[N+1][sum+1];
        return helper(coins, N-1, sum, dp);
    }
}

// Tabulation
class Solution {
    public long count(int coins[], int N, int sum) {
        // code here.
        long[][] dp=new long[N+1][sum+1];
        for(int i=0;i<=sum;i++)
            if(i%coins[0]==0) dp[0][i]=1;
        
        for(int i=1;i<N;i++){
            for(int j=0;j<=sum;j++){
                long notTake=dp[i-1][j];
                long take=0;
                if(j>=coins[i]) take=dp[i][j-coins[i]];
                dp[i][j]=take+notTake;
            }
        }
        
        return dp[N-1][sum];
    }
}