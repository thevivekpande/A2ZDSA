// Recursion
class Solution
{
    private static int helper(int a, int b){
        if(a<0 || b<0) return 0;
        if(a==0 && b==0) return 1;
        int up=helper(a-1, b);
        int left=helper(a, b-1);
        return dp[a][b]=up+left;
    }
    //Function to find total number of unique paths.
    public static int NumberOfPath(int a, int b) 
    {
        //Your code here
        return helper(a-1, b-1);
    }
}

// Memoization
class Solution
{
    private static int helper(int a, int b, int[][] dp){
        if(a<0 || b<0) return 0;
        if(a==0 && b==0) return 1;
        if(dp[a][b]!=0) return dp[a][b];
        int up=helper(a-1, b, dp);
        int left=helper(a, b-1, dp);
        return dp[a][b]=up+left;
    }
    //Function to find total number of unique paths.
    public static int NumberOfPath(int a, int b) 
    {
        //Your code here
        int[][] dp=new int[a+1][b+1];
        return helper(a-1, b-1, dp);
    }
}

// Tabulization
class Solution
{
    //Function to find total number of unique paths.
    public static int NumberOfPath(int a, int b) 
    {
        //Your code here
        int[][] dp=new int[a+1][b+1];
        for(int i=1;i<=a;i++){
            for(int j=1;j<=b;j++){
                if(i==1 && j==1) dp[i][j]=1;
                else{
                    int up=dp[i-1][j];
                    int left=dp[i][j-1];
                    dp[i][j]=up+left;
                }
            }
        }
        return dp[a][b];
    }
}