class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<int[]>> graph=new ArrayList<>();
        for(int i=0;i<n;i++)
            graph.add(new ArrayList<>());
        
        for(int[] road : roads){
            graph.get(road[0]).add(new int[]{road[1], road[2]});
            graph.get(road[1]).add(new int[]{road[0], road[2]});
        }
        
        int[] dist=new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int[] ways=new int[n];
        dist[0]=0;
        ways[0]=1;
        int mod=(int) (1e9 + 7);
        
        PriorityQueue<int[]> heap=new PriorityQueue<>((a, b) -> a[1]-b[1]);
        heap.offer(new int[]{0, 0});
        
        while(!heap.isEmpty()){
            int[] cur=heap.poll();
            int node=cur[0];
            int wt=cur[1];
            
            if(wt>dist[node]) continue;
            
            for(int[] it : graph.get(node)){
                int nextNode=it[0];
                int nextWt=it[1];
                
                if(wt+nextWt<dist[nextNode]){
                    ways[nextNode]=ways[node];
                    dist[nextNode]=wt+nextWt;
                    heap.offer(new int[]{nextNode, wt+nextWt});
                }else if(wt+nextWt==dist[nextNode]){
                    ways[nextNode]=(ways[node]+ways[nextNode])%mod;
                }
            }
        }
        
        return ways[n-1]%mod;
        
    }
}