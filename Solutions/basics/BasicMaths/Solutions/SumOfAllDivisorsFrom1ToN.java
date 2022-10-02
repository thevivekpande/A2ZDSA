class Solution{
    static long sumOfDivisors(int N){
        // code here
        long res=0;
        for(int i=1;i<=N;i++)
            res+=(N/i)*i;
        return res;
    }
}