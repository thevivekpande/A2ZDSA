// Leetcode
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int res=0;
        int n=grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;
        Queue<int[]> q = new LinkedList();
        q.offer(new int[]{0,0});
        int[][] dir=new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        boolean[][] isVis=new boolean[n][n];
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] cur=q.poll();
                if(cur[0]==n-1 && cur[1]==n-1) return res+1;
                for(int j=0;j<8;j++){
                    int curX=cur[0]+dir[j][0];
                    int curY=cur[1]+dir[j][1];
                    if(curX<0 || curX>=n || curY<0 || curY>=n) continue;
                    if(!isVis[curX][curY] && grid[curX][curY]==0){
                        isVis[curX][curY]=true;
                        q.offer(new int[]{curX, curY});
                    }
                }
            }
            res++;
        }
        return -1;
    }
}


// GeeksForGeeks
class Solution {
    int shortestPath(int[][] grid, int[] src, int[] dest) {
        // Your code here
        int res=0;
        int n=grid.length;
        int m=grid[0].length;
        if(src[0]>=n || src[1]>=m || dest[0]>=n || dest[1]>=m) return -1;
        if(grid[src[0]][src[1]]==0 || grid[dest[0]][dest[1]]==0) return -1;
        Queue<int[]> q = new LinkedList();
        q.offer(src);
        int[][] dir=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        boolean[][] isVis=new boolean[n][m];
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] cur=q.poll();
                if(cur[0]==dest[0] && cur[1]==dest[1]) return res;
                for(int j=0;j<4;j++){
                    int curX=cur[0]+dir[j][0];
                    int curY=cur[1]+dir[j][1];
                    if(curX<0 || curX>=n || curY<0 || curY>=m) continue;
                    if(!isVis[curX][curY] && grid[curX][curY]==1){
                        isVis[curX][curY]=true;
                        q.offer(new int[]{curX, curY});
                    }
                }
            }
            res++;
        }
        return -1;
    }
}
