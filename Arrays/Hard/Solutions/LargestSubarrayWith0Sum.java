class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        HashMap<Integer, Integer> map=new HashMap();
        int sum=0, res=0;
        
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum==0)
                res=Math.max(res, i+1);
            if(map.containsKey(sum))
                res=Math.max(res, i-map.get(sum));
            if(!map.containsKey(sum))
                map.put(sum, i);
        }
        
        return res;
    }
}