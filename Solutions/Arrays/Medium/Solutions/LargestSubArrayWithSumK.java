lass Solution{
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int A[], int N, int K) {
        //Complete the function
        int res=0, sum=0;
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        for(int i=0;i<N;i++){
            sum+=A[i];
            if(sum==K){
                res=Math.max(res , i+1);
            }else if(map.containsKey(sum-K)){
                res=Math.max(res, i-map.get(sum-K));
            }
            if(!map.containsKey(sum))
                map.put(sum , i);
        }
        return res;
    }
    
    
}