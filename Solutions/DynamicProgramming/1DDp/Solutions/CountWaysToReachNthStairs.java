// Recursion
class Solution
{
    int mod=(int)(1e9 + 7);
    
    int helper(int n){
        if(n==1) return 1;
        if(n==2) return 2;
        return (helper(n-1)%mod + helper(n-2)%mod)%mod;
    }

    //Function to count number of ways to reach the nth stair.
    int countWays(int n)
    {
        // your code here
        return helper(n);
    }
}

// Memoization
class Solution
{
    int mod=(int)(1e9 + 7);
    
    int helper(int n, int[] dp){
        if(n==1) return 1;
        if(n==2) return 2;
        if(dp[n]!=0) return dp[n];
        return dp[n]=(helper(n-1, dp)%mod + helper(n-2, dp)%mod)%mod;
    }
    //Function to count number of ways to reach the nth stair.
    int countWays(int n)
    {
        // your code here
        int[] dp=new int[n+1];
        return helper(n, dp);
    }
}

// Top Down
class Solution
{
    int mod=(int)(1e9 + 7);
    //Function to count number of ways to reach the nth stair.
    int countWays(int n)
    {
        // your code here
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=2;
        for(int i=2;i<n;i++){
            dp[i]=(dp[i-1]%mod + dp[i-2]%mod)%mod;
        }
        return dp[n-1];
    }
}

// Space-Optimization
class Solution
{
    int mod=(int)(1e9 + 7);
    //Function to count number of ways to reach the nth stair.
    int countWays(int n)
    {
        // your code here
        if(n<=2) return n;
        int first=1, second=2;
        for(int i=2;i<n;i++){
            int temp=(first%mod + second%mod)%mod;
            first=second;
            second=temp;
        }
        return second;
    }
}

