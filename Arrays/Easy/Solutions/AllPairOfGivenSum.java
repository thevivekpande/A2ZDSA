class Solution {
    public pair[] allPairs( long A[], long B[], long N, long M, long X) {
        // Your code goes here 
        Arrays.sort(A);
        List<pair> list=new ArrayList<>();
        Set<Long> set=new HashSet<>();
        for(long i:B)
            set.add(i);
        for(long i:A){
            if(set.contains(X-i))
                list.add(new pair(i, X-i));
        }
        int n=list.size();
        pair[] res=new pair[n];
        for(int i=0;i<n;i++)
            res[i]=list.get(i);
        return res;
    }
}