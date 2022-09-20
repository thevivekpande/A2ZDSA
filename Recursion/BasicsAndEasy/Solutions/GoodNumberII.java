class Solution {
    boolean check(int n, int d, int sum){
        if(n<=0) return true;
        if(n%10 <= sum || n%10==d) return false;
        return check(n/10, d, sum+n%10);
    }
    ArrayList<Integer> goodNumbers(int L, int R, int D) {
        // code here
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=L;i<=R;i++){
            if(i%10==D) continue;
            if(check(i/10, D, i%10))
                res.add(i);
        }
        return res;
    }
}