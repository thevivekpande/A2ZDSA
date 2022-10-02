class Solution{
    static void helper(ArrayList<Long> res, long N, long cur, long idx){
        if(cur>N) return;
        res.add(cur);
        helper(res, N, cur*idx, idx+1);
    }
    static ArrayList<Long> factorialNumbers(long N){
        // code here
        ArrayList<Long> res=new ArrayList();
        helper(res, N, 1, 2);
        return res;
    }
}