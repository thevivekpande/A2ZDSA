class Solution {
    static long gcd(long a, long b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
    
    static long lcm(long a, long b){
        return (a/(gcd(a, b)))*b;
    }
    static Long[] lcmAndGcd(Long A , Long B) {
        // code here
        Long[] res=new Long[2];
        res[0]=lcm(A, B);
        res[1]=gcd(A, B); 
        return res;
    }
};