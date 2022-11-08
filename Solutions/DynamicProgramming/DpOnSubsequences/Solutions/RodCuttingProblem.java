// Recursion
class Solution{
    private int helper(int[] price, int ind, int n){
        if(ind==1){
            return price[0]*n;
        }
        
        int notTake=helper(price, ind-1, n);
        int take=0;
        if(n>=ind) take=price[ind-1]+helper(price, ind, n-ind);
        return Math.max(take, notTake);
    }
    public int cutRod(int price[], int n) {
        //code here
        int len=price.length;
        return helper(price, len, n);
    }
}

// Memoization
class Solution{
    private int helper(int[] price, int ind, int n, int[][] dp){
        if(ind==1){
            return price[0]*n;
        }
        
        if(dp[ind][n]!=0) return dp[ind][n];
        
        int notTake=helper(price, ind-1, n, dp);
        int take=0;
        if(n>=ind) take=price[ind-1]+helper(price, ind, n-ind, dp);
        return dp[ind][n]=Math.max(take, notTake);
    }
    public int cutRod(int price[], int n) {
        //code here
        int len=price.length;
        int[][] dp=new int[len+1][n+1];
        
        return helper(price, len, n, dp);
    }
}

// Tabulation
class Solution{
    public int cutRod(int price[], int n) {
        //code here
        int len=price.length;
        int[][] dp=new int[len+1][n+1];
        
        for(int i=0;i<=n;i++)
            dp[1][i]=price[0]*i;
        
        for(int i=2;i<=len;i++){
            for(int j=0;j<=n;j++){
                int notTake=dp[i-1][j];
                int take=0;
                if(j>=i) take=price[i-1]+dp[i][j-i];
                dp[i][j]=Math.max(take, notTake);
            }
        }
        
        return dp[len][n];
    }
}