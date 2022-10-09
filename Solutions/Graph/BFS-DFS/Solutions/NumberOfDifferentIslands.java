class Solution {
    private void dfs(int i, int j, int[][] grid, List<Integer> list, int sI, int sJ){
        int m=grid.length, n=grid[0].length;
        if(i>=m || i<0 || j>=n || j<0 || grid[i][j]==0) return;
        grid[i][j]=0;
        list.add(i-sI);
        list.add(j-sJ);
        dfs(i+1, j, grid, list, sI, sJ);
        dfs(i-1, j, grid, list, sI, sJ);
        dfs(i, j-1, grid, list, sI, sJ);
        dfs(i, j+1, grid, list, sI, sJ);
    }
    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int m=grid.length, n=grid[0].length;
        Set<List<Integer>> set=new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    List<Integer> list=new ArrayList<>();
                    dfs(i, j, grid, list, i, j);
                    set.add(list);
                }
            }
        }
        return set.size();
    }
}
