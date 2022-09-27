class Solution
{
    //Function to return the minimum cost of connecting the ropes.
    long minCost(long arr[], int n) 
    {
        // your code here
        PriorityQueue<Long> pq=new PriorityQueue<>();
        
        for(long i : arr)
            pq.offer(i);
        
        long res=0;
        while(pq.size()>=2){
            long a=pq.poll(), b=pq.poll();
            res+=a+b;
            pq.offer(a+b);
        }
        
        return res;
    }
}