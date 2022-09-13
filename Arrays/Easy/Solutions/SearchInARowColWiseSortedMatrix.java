class Sol
{
    private static int search(int[][] mat, int r, int target){
        int l=0, h=mat[0].length-1;
        while(l<=h){
            int mid=l+((h-l)>>1);
            if(mat[r][mid]==target) return 1;
            else if(mat[r][mid]>target) h=mid-1;
            else l=mid+1;
        }
        return 0;
    }
    public static int matSearch(int mat[][], int N, int M, int X)
    {
        // your code here
        int l=0, r=N-1;
        for(int i=0;i<N;i++){
            if(mat[i][0]<=X && mat[i][M-1]>=X)
                if(search(mat, i, X)==1) return 1;
        }
        return 0;
    }
}