class Solution {
    public int reverse(int x) {
        int res=0;
        int sign=(x<0)?-1:1;
        x*=sign;
        while(x>0){
            res=res*10+(x%10);
            if(res%10 != x%10) return 0;
            x/=10;
        }
        return res*sign;
    }
}