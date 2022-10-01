
// User function Template for Java

class Solution{
    static List<Integer> minPartition(int N)
    {
        // code here
        List<Integer> res=new ArrayList();
        int[] coins=new int[]{2000, 500, 200, 100, 50, 20, 10, 5, 2, 1};
        for(int i=0;i<10 && N>0;i++){
            while(N>=coins[i]){
                res.add(coins[i]);
                N-=coins[i];
            }
        }
        return res;
    }
}