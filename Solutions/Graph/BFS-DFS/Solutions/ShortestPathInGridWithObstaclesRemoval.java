class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m=grid.length, n=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        int[][] dirs=new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        q.offer(new int[]{0, 0, 0});
        boolean[][][] isVis=new boolean[m+1][n+1][k+1];
        isVis[0][0][0]=true;
        int res=0;
        while(!q.isEmpty()){
            int size=q.size();
            
            for(int i=0;i<size;i++){
                int[] cur=q.poll();
                int curX=cur[0], curY=cur[1], curK=cur[2];
                
                if(curX==m-1 && curY==n-1) return res; 
                
                for(int[] dir:dirs){
                    int nextX=curX+dir[0], nextY=curY+dir[1], nextK=curK; 
                    
                    if(nextX<0 || nextY<0 || nextX>=m || nextY>=n) continue;
                    if(grid[nextX][nextY]==1) nextK++;
                    if(nextK<=k && !isVis[nextX][nextY][nextK]) {
                        isVis[nextX][nextY][nextK]=true;
                        q.offer(new int[]{nextX, nextY, nextK});
                    }
                    }
                }
                
                res++;
            }
        
        return -1;
    }
}
