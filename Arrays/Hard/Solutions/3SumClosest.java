class Solution
{
    static int closest3Sum(int A[], int N, int X)
    {
        // code here
        Arrays.sort(A);
        int diff=Integer.MAX_VALUE, res=Integer.MAX_VALUE;
        for(int i=0;i<N-2;i++){
            int low=i+1, high=N-1, sum=X-A[i];
            while(low<high){
                int cur=A[low]+A[high];
                if(cur==sum) return X;
                if(diff>Math.abs(cur-sum)){
                    diff=Math.abs(cur-sum);
                    res=cur+A[i];
                }
                if(cur>sum)
                    high--;
                else 
                    low++;
            }
        }
        
        return res;
    }
}