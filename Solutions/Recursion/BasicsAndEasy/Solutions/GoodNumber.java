class Solution {
    int mod=(int)1e9+7;
    private long pow(int x, long n){
        if(n==0) return 1;
        long res=pow(x, n/2);
        if(n%2==0){
            return (res*res)%mod;
        }else{
            return (((x*res)%mod)*res)%mod;
        }
    }
    public int countGoodNumbers(long n) {
        return (int)((pow(5, (n+1)/2) * pow(4, n/2))%mod);
    }
}