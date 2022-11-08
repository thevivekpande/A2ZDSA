class Solution{
    static List<Integer> minPartition(int N)
    {
        // code here
        int[] coins=new int[]{ 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
        List<Integer> res=new ArrayList<>();
        for(int i=9;i>=0 && N>0;i--){
            while(coins[i]<=N){
                res.add(coins[i]);
                N-=coins[i];
            }
        }
        
        return res;
    }
}