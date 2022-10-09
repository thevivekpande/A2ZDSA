/*
Explanation : Use boundary DFS
Steps
    - use dfs from extreme boundaries (rows and columns both), 
    - mark all 1s which are connected from boundary to any random number expect 0 & 1 (let's say 2),
    - since these 1s are connected to boundaries so they can't be covered from all the sides.
    and these can be walk of from boundaries, 
    - now count all the remaining 1s which are surrounded by 0s and are cannot walk off in any number of moves
*/

class Solution {
    private void dfs(int i, int j, int[][] grid){
        int m=grid.length, n=grid[0].length;
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]!=1) return;
        grid[i][j]=2;
        dfs(i+1, j, grid);
        dfs(i-1, j, grid);
        dfs(i, j+1, grid);
        dfs(i, j-1, grid);
    }
    public int numEnclaves(int[][] grid) {
        int m=grid.length, n=grid[0].length;
		// extreme columns dfs
        for(int i=0;i<m;i++){
            if(grid[i][0]==1) dfs(i, 0, grid);
            if(grid[i][n-1]==1) dfs(i, n-1, grid);
        }
		// extreme rows dfs
        for(int i=0;i<n;i++){
            if(grid[0][i]==1) dfs(0, i, grid);
            if(grid[m-1][i]==1) dfs(m-1, i, grid);
        }
        int res=0;
		// count res
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) res++;
            }
        }
        return res;
    }
}
