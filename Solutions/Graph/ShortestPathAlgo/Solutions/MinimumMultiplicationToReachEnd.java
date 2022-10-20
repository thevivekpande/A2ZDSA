class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        // Your code here
        int mod=100000;
        PriorityQueue<int[]> heap=new PriorityQueue<>((a, b)->a[1]-b[1]);
        heap.offer(new int[]{start, 0});
        
        int[] dist=new int[100000];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start]=0;
        
        while(!heap.isEmpty()){
            int[] top=heap.poll();
            int node=top[0];
            int wt=top[1];
            if(node==end) return wt;
            
            for(int i:arr){
                int nextNode=(node*i)%mod;
                int nextWt=wt+1;
                if(nextWt<dist[nextNode]){
                    dist[nextNode]=nextWt;
                    heap.offer(new int[]{nextNode, nextWt});
                }
            }
        }
        
        return -1;
    }
}
