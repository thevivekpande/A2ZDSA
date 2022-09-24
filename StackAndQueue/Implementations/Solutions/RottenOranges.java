

class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        // Code here
        int m=grid.length, n=grid[0].length;
        int totalOranges=0;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0) totalOranges++;
                if(grid[i][j]==2) q.offer(new int[]{i, j});
            }
        }
        
        int[][] dir=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        int Oranges=0;
        int res=0;
        
        while(!q.isEmpty()){
            int size=q.size();
            Oranges+=size;
            for(int i=0;i<size;i++){
                int[] cur=q.poll();
                for(int j=0;j<4;j++){
                    int x=cur[0]+dir[j][0];
                    int y=cur[1]+dir[j][1];
                    
                    if(x<0 || y<0 || x>=m || y>=n || grid[x][y]!=1)  continue;
                    
                    grid[x][y]=2;
                    q.offer(new int[]{x, y});
                }
            }
            if(!q.isEmpty()) res++;
        }
        
        return totalOranges==Oranges?res:-1;
    }
}