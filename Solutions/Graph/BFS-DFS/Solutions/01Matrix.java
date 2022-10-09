class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length, n=mat[0].length;
        int[][] res=new int[m][n];
        
        for(int[] row : res)
            Arrays.fill(row, Integer.MAX_VALUE);
        
        Queue<int[]> q=new LinkedList<>();
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.offer(new int[]{i, j});
                    res[i][j]=0;
                }
            }
        }
        
        int[][] dirs=new int[][]{{1,0}, {0,1}, {-1, 0}, {0, -1}};
        
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] cur=q.poll();
                for(int j=0;j<4;j++){
                    int x=dirs[j][0]+cur[0];
                    int y=dirs[j][1]+cur[1];
                    
                    if(x<0 || y<0 || x>=m || y>=n) continue;
                    if(res[x][y]>res[cur[0]][cur[1]]+1){
                        res[x][y]=res[cur[0]][cur[1]]+1;
                        q.offer(new int[]{x, y});
                    }
                }
            }
        }
        
        return res;
    }
}