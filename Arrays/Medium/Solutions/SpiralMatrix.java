// Leetcode
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<>();
        int up=0, down=matrix.length-1, left=0, right=matrix[0].length-1;
        while(left<=right && up<=down){
            for(int i=left;i<=right;i++){
                res.add(matrix[up][i]);
            }
            up++;
            
            for(int i=up;i<=down;i++){
                res.add(matrix[i][right]);
            }
            right--;
            
            if(up<=down)
                for(int i=right;i>=left;i--){
                    res.add(matrix[down][i]);
                }
            down--;
            
            if(left<=right)
                for(int i=down;i>=up;i--){
                    res.add(matrix[i][left]);
                }
            left++;
        }
        return res;
    }
}

//GFG
class Solution
{
	public int findK(int a[][], int n, int m, int k)
	{
	    // Your code goes here
	    int left=0, right=m-1, up=0, down=n-1;
	    while(left<=right && up<=down){
	        for(int i=left;i<=right;i++){
	            k--;
	            if(k==0) return a[up][i];
	        }
	        up++;
	        
	        for(int i=up;i<=down;i++){
	            k--;
	            if(k==0) return a[i][right];
	        }
	        right--;
	        
	        if(up<=down)
	        for(int i=right;i>=left;i--){
	            k--;
	            if(k==0) return a[down][i];
	        }
	        down--;
	        
	        if(left<=right)
	        for(int i=down;i>=up;i--){
	            k--;
	            if(k==0) return a[i][left];
	        }
	        left++;
	    }
	    
	    return -1;
	}
}