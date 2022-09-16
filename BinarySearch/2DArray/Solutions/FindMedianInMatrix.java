class Solution {
    int median(int matrix[][], int r, int c) {
        // code here   
        int low=matrix[0][0], high=matrix[0][0];
        
        for(int i=0;i<r;i++){
            low=Math.min(matrix[i][0], low);
            high=Math.max(matrix[i][c-1], high);
        }
        
        while(low<=high){
            int mid=low+((high-low)>>1);
            int count=0;
            for(int i=0;i<r;i++)
                count+=countLessAndEquals(matrix, i, c, mid);
                
            if(count<=(r*c/2))
                low=mid+1;
            else
                high=mid-1;
        }
        
        return low;
    }
    
    private int countLessAndEquals(int[][] matrix, int ind, int col, int target){
        int low=0, high=col-1;
        while(low<=high){
            int mid=low+((high-low)>>1);
            if(matrix[ind][mid]<=target)
                low=mid+1;
            else 
                high=mid-1;
        }
        return low;
    }
}