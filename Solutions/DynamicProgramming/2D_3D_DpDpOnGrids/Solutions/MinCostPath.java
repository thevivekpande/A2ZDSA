// Using Dijkstra's
class Solution
{
    //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
    public int minimumCostPath(int[][] grid)
    {
        // Code here
        int m=grid.length, n=grid[0].length;
        int[][] minCost=new int[m][n];
        for(int[] row:minCost)
            Arrays.fill(row, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> heap=new PriorityQueue<>((a, b) -> a[2]-b[2]);
        minCost[0][0]=grid[0][0];
        heap.offer(new int[]{0, 0, grid[0][0]});
        
        int[][] dirs=new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        while(!heap.isEmpty()){
            int[] cur=heap.poll();
            int x=cur[0], y=cur[1], wt=cur[2];
            if(x==m-1 && y==n-1) return wt;
            
            for(int[] dir:dirs){
                int nx=x+dir[0], ny=y+dir[1];
                if(nx<0 || ny<0 || nx>=m || ny>=n) continue;
                
                if(wt+grid[nx][ny]<minCost[nx][ny]){
                    minCost[nx][ny]=wt+grid[nx][ny];
                    heap.offer(new int[]{nx, ny, minCost[nx][ny]});
                }
            }
        }
        
        return minCost[m-1][n-1];
    }
}