

class Solution {
    // Function to find the number of islands.
    int[][] dirs=new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
    
    public void dfs(char[][] grid, int i, int j, int n, int m){
        if(i<0 || i>=n || j<0 || j>=m || grid[i][j]=='0') 
            return;
        grid[i][j]='0';
        
        for(int[] dir : dirs){
            int x=dir[0];
            int y=dir[1];
            dfs(grid, i+x, j+y, n, m);
        }
    }
    
    public int numIslands(char[][] grid) {
        // Code here
        int count=0;
        int n=grid.length, m=grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    count++;
                    for(int[] dir : dirs){
                        int x=dir[0];
                        int y=dir[1];
                        dfs(grid, i+x, j+y, n, m);
                    }
                }
                
            }
        }
        return count;
    }
}