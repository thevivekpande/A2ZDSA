// GFG
class Solution
{
    private static void helper(int n, long[] res, int ind){
        if(ind==n) return;
        res[ind]=res[ind-1]+res[ind-2];
        helper(n, res, ind+1);
    }
    //Function to return list containing first n fibonacci numbers.
    public static long[] printFibb(int n) 
    {
        //Your code here
        long[] res=new long[n];
        res[0]=1;
        if(n==1) return res;
        res[1]=1;
        helper(n, res, 2);
        return res;
    }
}

// Leetcode
class Solution {
    public int fib(int n) {
        if(n<=1) return n;
        return fib(n-1)+fib(n-2);
    }
}