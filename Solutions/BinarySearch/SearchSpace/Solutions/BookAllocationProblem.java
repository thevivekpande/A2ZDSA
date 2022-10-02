class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        //Your code here
        if(N<M) return -1;
        int left=0, right=0;
        for(int a:A){
            left=Math.max(left, a);
            right+=a;
        }
        
        while(left<=right){
            int mid=left+((right-left)>>1);
            boolean isPos=isPossible(A, mid, M);
            if(isPos)
                right=mid-1;
            else 
                left=mid+1;
        }
        return left;
    }
    
    private static boolean isPossible(int[] arr, int mid, int limit){
        int count=1, cur=0;
        for(int a:arr){
            if(cur+a<=mid)
                cur=cur+a;
            else {
                cur=a;
                count++;
            }
        }
        return count<=limit;
    }
};