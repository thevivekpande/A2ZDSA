class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] nle=new int[n];
        int[] ple=new int[n];
        
        Stack<Integer> stack=new Stack();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i])
                stack.pop();
            ple[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        
        stack.clear();
        
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i])
                stack.pop();
            nle[i]=stack.isEmpty()?n:stack.peek();
            stack.push(i);
        }
        
        int res=0;
        for(int i=0;i<n;i++){
            res=Math.max(res, heights[i]*(nle[i]-ple[i]-1));
        }
        
        return res;
    }

    public int maximalRectangle(char[][] matrix) {
        int m=matrix.length, n=matrix[0].length;
        if(m==0 || n==0) return 0;
        int[] a=new int[n];
        int res=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                a[j]=matrix[i][j]=='0'?0:a[j]+1;
            }
            res=Math.max(res, largestRectangleArea(a));
        }
        return res;
    }
}