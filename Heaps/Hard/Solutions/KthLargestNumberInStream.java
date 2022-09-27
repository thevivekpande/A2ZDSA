class KthLargest {
    PriorityQueue<Integer> pq=new PriorityQueue();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k=k;
        for(int i:nums)
            pq.offer(i);
        while(pq.size()>k)
            pq.poll();
        
    }
    
    public int add(int val) {
        pq.offer(val);
        while(pq.size()>k)
            pq.poll();
        return pq.isEmpty()?-1:pq.peek();
    }
}

// GFG
class Solution {
    static int[] kthLargest(int k, int[] arr, int n) {
        // code here
        int[] res=new int[n];
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            pq.offer(arr[i]);
            if(pq.size()<k){
                res[i]=-1;
            }else{
                if(pq.size()>k)
                    pq.poll();
                res[i]=pq.peek();
            }
        }
        return res;
    }
};