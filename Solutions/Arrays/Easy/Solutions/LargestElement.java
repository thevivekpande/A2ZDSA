class Compute {
    public int largest(int arr[], int n)
    {
        int res=arr[0];
        for(int i:arr)
            res=Math.max(res, i);
        return res;
    }
}