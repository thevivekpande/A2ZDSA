class Solution
{
    public void shortest_distance(int[][] mat)
    {
        // Code here
        
        int n=mat.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==-1) mat[i][j]=(int)1e9;
            }
        }
        for(int v=0;v<n;v++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(i!=j  && (mat[i][j]>mat[i][v]+mat[v][j]))
                        mat[i][j]= mat[i][v]+mat[v][j];
                }
            }
        }
    }
}