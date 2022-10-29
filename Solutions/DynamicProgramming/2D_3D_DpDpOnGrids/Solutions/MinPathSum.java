// Recursion
class Solution {
    public int minPath(int i, int j, int[][] grid){
        if(i==0 && j==0) return grid[i][j];
        if(i<0 || j<0) return 201;
        int up=grid[i][j]+minPath(i-1, j, grid);
        int left=grid[i][j]+minPath(i, j-1, grid);
        return Math.min(up, left);
    }
    public int minPathSum(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        return minPath(m-1,n-1, grid, dp);
    }
}

//Memoization
class Solution {
    public int minPath(int i, int j, int[][] grid, int[][] dp){
        if(i==0 && j==0) return grid[i][j];
        if(i<0 || j<0) return 201;
        if(dp[i][j]!=0) return dp[i][j];
        int up=grid[i][j]+minPath(i-1, j, grid, dp);
        int left=grid[i][j]+minPath(i, j-1, grid,dp);
        return dp[i][j]=Math.min(up, left);
    }
    public int minPathSum(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        int[][] dp=new int[m][n];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        return minPath(m-1,n-1, grid, dp);
    }
}

// Tabulation
class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0) dp[i][j]=201;
                else if(i==1 && j==1) dp[i][j]=grid[i-1][j-1];
                else{
                    int up=grid[i-1][j-1]+dp[i-1][j];
                    int left=grid[i-1][j-1]+dp[i][j-1];
                    dp[i][j]=Math.min(up, left);
                }
            }
        }
        return dp[m][n];
    }
}