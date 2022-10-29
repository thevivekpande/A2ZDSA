// Recursion
class Solution {
    private int helper(int m, int n, int[][] arr){
        if(m<0 || n<0) return 0;
        if(arr[m][n]==1) return 0;
        if(m==0 && n==0) return 1;
        return helper(m-1, n, arr)+helper(m, n-1, arr);
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length, n=obstacleGrid[0].length;
        return helper(m-1, n-1, obstacleGrid);
    }
}

// Memoization
class Solution {
    private int helper(int m, int n, int[][] arr, int[][] dp){
        if(m<0 || n<0) return 0;
        if(arr[m][n]==1) return 0;
        if(m==0 && n==0) return 1;
        if(dp[m][n]!=0) return dp[m][n];
        return dp[m][n]=helper(m-1, n, arr, dp)+helper(m, n-1, arr, dp);
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length, n=obstacleGrid[0].length;
        int[][] dp=new int[m+1][n+1];
        return helper(m-1, n-1, obstacleGrid, dp);
    }
}

// Tabulation
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length, n=obstacleGrid[0].length;
        int[][] dp=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(obstacleGrid[i-1][j-1]==1) 
                    dp[i][j]=0;
                else if(i==1 && j==1)
                    dp[i][j]=1;
                else
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                
            }
        }
        return dp[m][n];
    }
}