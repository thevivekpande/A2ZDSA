class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] graph=new int[n][n];
        for(int[] row:graph)
            Arrays.fill(row, (int)1e7);
        
        for(int[] edge:edges){
            graph[edge[0]][edge[1]]=edge[2];
            graph[edge[1]][edge[0]]=edge[2];
        }
        
        int res=-1, minCity=Integer.MAX_VALUE;
        for(int v=0;v<n;v++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(i!=j && graph[i][j]>graph[i][v]+graph[v][j])
                        graph[i][j]=graph[i][v]+graph[v][j];
                }
            }
        }
        
        for(int i=0;i<n;i++){
            int numCity=0;
            for(int j=0;j<n;j++){
                if(graph[i][j]<=distanceThreshold){
                    numCity++;
                }
            }
            
            if(numCity<=minCity){
                minCity=numCity;
                res=i;
            }
        }
        
        return res;
    }
}