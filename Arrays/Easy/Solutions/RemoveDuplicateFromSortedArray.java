class Solution {
    int remove_duplicate(int arr[],int N){
        // code here
        int i=0;
        for(int j=1;j<N;j++){
            if(arr[i]!=arr[j]){
                arr[++i]=arr[j];
            }
        }
        return i+1;
    }
}