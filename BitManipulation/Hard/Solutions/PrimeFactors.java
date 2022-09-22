class Solution
{
    public int[] AllPrimeFactors(int n)
    {
        // code here
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=2;i*i<=n;i++){
            if(n%i==0) list.add(i);
            while(n%i==0) n/=i;
        }
        
        if(n!=1) list.add(n);
        
        int[] res=new int[list.size()];
        
        for(int i=0;i<res.length;i++)
            res[i]=list.get(i);
            
        return res;
    }
}