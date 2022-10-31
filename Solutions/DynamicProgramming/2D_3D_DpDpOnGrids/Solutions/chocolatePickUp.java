// Recursion
public class Solution {
    private static int helper(int r1, int c1, int c2, int r, int c, int[][] grid){
        if(r1>r || c1>c || c2>c || c1<0 || c2<0 || r1<0) return 0;
        if(r1==r){
            if(c1==c2) return grid[r1][c1];
            return grid[r1][c1]+grid[r1][c2];
        }
        int res= (int)(-1e9);
        for(int a=-1;a<=1;a++){
            for(int b=-1;b<=1;b++){
                int val=0;
                if(c1==c2) val+=grid[r1][c1];
                else val+=grid[r1][c1] + grid[r1][c2];
                val+=helper(r1+1, c1+a, c2+b, r, c, grid);
                res=Math.max(res, val);
            }
        }
        return res;
    }
	public static int maximumChocolates(int r, int c, int[][] grid) {
		// Write your code here.
        return helper(0, 0, c-1, r-1, c-1, grid);
	}
}

// Memoization
public class Solution {
    private static int helper(int r1, int c1, int c2, int r, int c, int[][] grid, int[][][] dp){
        if(r1>r || c1>c || c2>c || c1<0 || c2<0 || r1<0) return 0;
        if(r1==r){
            if(c1==c2) return grid[r1][c1];
            return grid[r1][c1]+grid[r1][c2];
        }
        if(dp[r1][c1][c2]!=0) return dp[r1][c1][c2];
        int res= (int)(-1e9);
        for(int a=-1;a<=1;a++){
            for(int b=-1;b<=1;b++){
                int val=0;
                if(c1==c2) val+=grid[r1][c1];
                else val+=grid[r1][c1] + grid[r1][c2];
                val+=helper(r1+1, c1+a, c2+b, r, c, grid, dp);
                res=Math.max(res, val);
            }
        }
        return dp[r1][c1][c2]=res;
    }
	public static int maximumChocolates(int r, int c, int[][] grid) {
		// Write your code here.
        int[][][] dp=new int[r][c][c];
        return helper(0, 0, c-1, r-1, c-1, grid, dp);
	}
}