class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length, m=heights[0].length;
        int[][] dist=new int[n][m];
        for(int[] row:dist)
            Arrays.fill(row, Integer.MAX_VALUE);
        
        int[][] dir=new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        PriorityQueue<int[]> heap=new PriorityQueue<>((a, b)->a[0]-b[0]);
        heap.offer(new int[]{0, 0, 0});
        
        while(!heap.isEmpty()){
            int[] cur=heap.poll();
            int d=cur[0], r=cur[1], c=cur[2];
                
            if(d>dist[r][c]) continue;
            if(r==n-1 && c==m-1) return d;
            for(int i=0;i<4;i++){
                int nr=r+dir[i][0];
                int nc=c+dir[i][1];
                if(nr>=0 && nc>=0 && nr<n && nc<m){
                    int newDist=Math.max(d, Math.abs(heights[nr][nc]-heights[r][c]));
                    if(newDist<dist[nr][nc]){
                    dist[nr][nc]=newDist;
                    heap.offer(new int[]{newDist, nr, nc});
                    }
                }
            }
        }
        
        return -1;
    }
}