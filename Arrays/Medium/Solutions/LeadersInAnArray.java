class Solution{
    //Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
        ArrayList<Integer> res=new ArrayList<>();
        res.add(arr[n-1]);
        int last=arr[n-1];
        for(int i=n-2;i>=0;i--){
            if(arr[i]>=last)
                res.add(arr[i]);
            last=Math.max(last, arr[i]);
        }
        Collections.reverse(res);
        return res;
    }
}
