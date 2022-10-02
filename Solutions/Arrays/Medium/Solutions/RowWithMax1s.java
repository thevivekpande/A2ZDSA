// optimised
class Solution {
    int rowWithMax1s(int arr[][], int n, int m) {
        // code here
        int j=m-1, res=0;
        for(int i=0;i<n;i++){
            while(j>=0  && arr[i][j]==1){
                j--;
                res=i;
            }
        }
        return res==0 && arr[0][m-1]==0?-1:res;
    }
}