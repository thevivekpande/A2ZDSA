// Recursion
class Solution {
    private int helper(int i, int j, List<List<Integer>> triangle){
        int n=triangle.size();
        if(i==n-1) return triangle.get(i).get(j);
        return triangle.get(i).get(j)+Math.min(helper(i+1, j, triangle), helper(i+1, j+1, triangle));
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        return helper(0, 0, triangle);
    }
}

// Memoization
class Solution {
    private int helper(int i, int j, List<List<Integer>> triangle, int[][] dp){
        int n=triangle.size();
        if(i==n-1) return triangle.get(i).get(j);
        if(dp[i][j]!=-1) return dp[i][j];
        return dp[i][j]=triangle.get(i).get(j)+Math.min(helper(i+1, j, triangle, dp), helper(i+1, j+1, triangle, dp));
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][] dp=new int[n][n];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        return helper(0, 0, triangle, dp);
    }
}

// Tabulization
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++) dp[n-1][i]=triangle.get(n-1).get(i);
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=i;j++)
                dp[i][j]=triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
        }
        return dp[0][0];
    }
}

