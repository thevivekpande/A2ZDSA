// Leetcode
class Solution {
    public double myPow(double x, int n) {
        if(x==0 || x==1 || n==1) return x;
        if(n==0) return 1;
        if(n<0){
            return 1/x * myPow(1/x, -(n+1));
        }
        return n%2==0?myPow(x*x, n/2):x*myPow(x*x, n/2);
    }
}

// GFG
class Solution
{
    int mod=1000000007;
    
    long pow(int n, int m){
        if(n==0) return 0;
        if(m==0) return 1;
        long res;
        if(m%2==0){
            res= pow(n, m/2);
            res= (res*res)%mod;
        }else{
            res=n%mod;
            res=(res*(pow(n, m-1)%mod))%mod;
        }
        return (res+mod)%mod;
    }
    
    long power(int N,int R)
    {
        return pow(N, R);
    }

}
