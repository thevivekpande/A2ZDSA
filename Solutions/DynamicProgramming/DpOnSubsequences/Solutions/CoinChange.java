// Recursion
class Solution {
    private int mod=(int) 1e9 + 7;
    private int helper(int ind, int[] coins, int amount){
        if(ind==0){
            if(amount%coins[0]==0)
                return amount/coins[0];
            return mod;
        }
        
        int notTake=helper(ind-1, coins, amount);
        int take=mod;
        if(amount>=coins[ind])
            take=1+helper(ind, coins, amount-coins[ind]);
        return Math.min(take, notTake);
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int res=helper(n-1, coins, amount);
        return res==mod?-1:res;
    }
}

// Memoization
class Solution {
    private int mod=(int) 1e9 + 7;
    private int helper(int ind, int[] coins, int amount, int[][] dp){
        if(ind==0){
            if(amount%coins[0]==0)
                return amount/coins[0];
            return mod;
        }
        
        if(dp[ind][amount]!=-1) return dp[ind][amount];
        
        int notTake=helper(ind-1, coins, amount, dp);
        int take=mod;
        if(amount>=coins[ind])
            take=1+helper(ind, coins, amount-coins[ind], dp);
        return dp[ind][amount]=Math.min(take, notTake);
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n+1][amount+1];
        for(int[] row:dp)
            Arrays.fill(row, -1);
        int res=helper(n-1, coins, amount, dp);
        return res==mod?-1:res;
    }
}

// Tabulation
class Solution {
    private int mod=(int) 1e9 + 7;
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n+1][amount+1];
        
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0) dp[0][i]=i/coins[0];
            else dp[0][i]=mod;
        }
        
        for(int i=1;i<n;i++){
            for(int a=0;a<=amount;a++){
                int notTake=dp[i-1][a];
                int take=mod;
                if(a>=coins[i])
                    take=1+dp[i][a-coins[i]];
                dp[i][a]=Math.min(take, notTake);
            }
        }
        
        int res=dp[n-1][amount];
        return res==mod?-1:res;
    }
}