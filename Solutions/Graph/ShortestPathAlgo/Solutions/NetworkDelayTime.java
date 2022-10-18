class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<int[]>> map=new HashMap<>();
        for(int[] time:times){
            map.putIfAbsent(time[0], new ArrayList<>());
            map.get(time[0]).add(new int[]{time[1], time[2]});
        }
        
        int[] dist=new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> heap=new PriorityQueue<>((a, b)->a[1]-b[1]);
        heap.offer(new int[]{k, 0});    
        dist[k]=0;
    
        while(!heap.isEmpty()){
            int[] cur=heap.poll();
            int curNode=cur[0], curWt=cur[1];
            
            if(curWt>dist[curNode] || !map.containsKey(curNode)) continue;
            
            for(int[] it:map.get(curNode)){
                int nextNode=it[0], nextWt=it[1];
                if(dist[nextNode]>curWt+nextWt){
                    dist[nextNode]=curWt+nextWt;
                    heap.offer(new int[]{nextNode, curWt+nextWt});
                }
            }
        }
        
        int res=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            res=Math.max(res, dist[i]);
        }
        
        return res==Integer.MAX_VALUE?-1:res;
    }
}