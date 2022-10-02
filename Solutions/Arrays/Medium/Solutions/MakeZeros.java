class Solution
{
    public void  MakeZeros(int[][] matrix)
    {
        // code here;
        int m=matrix.length, n=matrix[0].length;
        int[][] isVis=new int[m][n];
        int[][] dirs=new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0,1}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    int sum=0;
                    for(int[] dir:dirs){
                        int x=i+dir[0];
                        int y=j+dir[1];
                        if(x>=0 && x<m && y>=0 && y<n){
                            sum+=matrix[x][y];
                            isVis[x][y]=-1;
                        }
                    }
                    isVis[i][j]=sum;
                }
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isVis[i][j]==-1) matrix[i][j]=0;
                if(isVis[i][j]>0) matrix[i][j]=isVis[i][j];
            }
        }
        
    }
}