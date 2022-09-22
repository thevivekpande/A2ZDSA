class Solution {
    public int minBitFlips(int start, int goal) {
        int res=0;
        int count=0;
        while((1<<count)<=Math.max(start, goal)){
            if((start&(1<<count))!=(goal&(1<<count++))) res++;
        }
        return res;
    }
}