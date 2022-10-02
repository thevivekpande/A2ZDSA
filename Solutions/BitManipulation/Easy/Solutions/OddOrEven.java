class Solution{
    static String oddEven(int N){
        // code here
        // return N!=((N>>1)<<1)?"odd":"even";
        return (N&1)!=0?"odd":"even";
    }
}