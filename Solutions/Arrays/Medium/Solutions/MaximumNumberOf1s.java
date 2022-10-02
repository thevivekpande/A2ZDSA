class Solve {
    // m is maximum of number zeroes allowed to flip
    int findZeroes(int arr[], int n, int m) {
        // code here
        int res=0, cur=0, i=0, j=0, zeros=0;
        for(i=0;i<n;i++){
            if(arr[i]==0)
                zeros++;
            if(zeros>m){
                if(arr[j]==0)
                    zeros--;
                j++;
            }else{
                res=Math.max(res, i-j+1);
            }
        }
        return res;
    }
}