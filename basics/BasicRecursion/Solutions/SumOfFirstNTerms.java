// Recursion (TLE)
class Solution {   
    long sumOfSeries(long N) {
        // code here
        if(N==0) return 0;
        return (N*N*N) + sumOfSeries(N-1);
    }
}

// Mathematics
class Solution {
    long sumOfSeries(long N) {
        // code here
        if(N==0) return 0;
        return (N*(N+1)/2)*(N*(N+1)/2);
    }
}