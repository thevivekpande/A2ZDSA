class Solution{
    static int setBit(int N){
        // code here
        return ((N&(N+1))==0)?N:N|(N+1);
    }
}