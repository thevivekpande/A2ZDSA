class Solution{
    static int evenlyDivides(int N){
        // code here
        int res=0;
        int temp=N;
        while(temp>0){
            int rem=temp%10;
            if(rem!=0 && N%rem==0)
                res++;
            temp/=10;
        }
        return res;
    }
}