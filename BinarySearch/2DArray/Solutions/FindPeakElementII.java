class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int startCol=0, endCol=mat[0].length-1;
        while(startCol<=endCol){
            int maxRow=0;
            int midCol=startCol+((endCol-startCol)>>1);
            
            for(int i=0;i<mat.length;i++)
                maxRow=mat[i][midCol]>=mat[maxRow][midCol]?i:maxRow;
            
            boolean isLeftGreater = midCol-1>=startCol && mat[maxRow][midCol]<mat[maxRow][midCol-1];
            boolean isRightGreater = midCol+1<=endCol && mat[maxRow][midCol]<mat[maxRow][midCol+1];
            
            if(!isLeftGreater && !isRightGreater)
                return new int[]{maxRow, midCol};
            else if(isLeftGreater) endCol=midCol-1;
            else startCol=midCol+1;
        }
        return new int[]{-1, -1};
    }
}