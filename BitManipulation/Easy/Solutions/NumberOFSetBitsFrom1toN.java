class Solution{
    private static int getHighestPow(int n){
        int x=0;
        while((1<<x)<=n)
            x++;
        return x-1;
    }
    //Function to return sum of count of set bits in the integers from 1 to n.
    public static int countSetBits(int n){
        // Your code here
        if(n<=1) return n;
        int x=getHighestPow(n);
        return (x*((1<<(x-1))))+(n-(1<<(x))+1)+ countSetBits(n-(1<<x));
    }
}