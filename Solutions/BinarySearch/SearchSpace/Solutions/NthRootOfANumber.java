lass Solution
{
    public int NthRoot(int n, int m)
    {
        // code here
        int left=0, right=m;
        if(n==1) return m;
        while(left<=right){
            int mid=left+((right-left)>>1);
            int val=(int)Math.pow(mid, n);
            if(val==m) return mid;
            else if(val<m) left=mid+1;
            else right=mid-1;
        }
        return -1;
    }
}