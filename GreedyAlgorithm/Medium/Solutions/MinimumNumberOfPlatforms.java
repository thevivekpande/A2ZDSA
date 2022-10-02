class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        int res=0, curPlat=1;
        int i=0, j=1;
        while(i<n && j<n){
            // if next train is arriving before departure of cur train
            // we will need one more platform
            if(dep[i]>=arr[j]){
                j++;
                curPlat++;
            }
            // if cur train is departed before arrival of next train
            // we can adjust with same platform
            else{
                curPlat--;
                i++;
            }
            res=Math.max(res, curPlat);
        }
        return res;
    }
    
}
