class Solution {
    public int orangesRotting(int[][] grid) {
        int totalOranges=0;
        Queue<int[]> q=new LinkedList<>();
        int m=grid.length, n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2) q.offer(new int[]{i, j});
                if(grid[i][j]!=0) totalOranges++;
            }
        }
        
        int[][] dir=new int[][]{{0,-1}, {-1, 0}, {0, 1}, {1, 0}};
        int oranges=0, time=0;
        
        while(!q.isEmpty()){
            int size=q.size();
            oranges+=size;
            for(int i=0;i<size;i++){
                int[] cur=q.poll();
                for(int j=0;j<4;j++){
                    
                    int x=cur[0]+dir[j][0];
                    int y=cur[1]+dir[j][1];
                    
                    if(x<m && x>=0 && y<n && y>=0 && grid[x][y]==1){
                        grid[x][y]=2;
                        q.offer(new int[]{x, y});
                    }
                }
            }
            if(!q.isEmpty()) time++;
        }
        
        return totalOranges==oranges?time:-1;
    }
}