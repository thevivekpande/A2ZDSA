class Solution {
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++)
            graph.add(new ArrayList<>());
        
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        Queue<Integer> q=new LinkedList<>();
        int[] res=new int[n];
        Arrays.fill(res, (int)(1e9));
        res[src]=0;
        q.offer(src);
        
        while(!q.isEmpty()){
            int node=q.poll();
            for(int it:graph.get(node)){
                if(res[node]+1<res[it]){
                    res[it]=res[node]+1;
                    q.offer(it);
                }
            }
        }
        
        for(int i=0;i<n;i++)
            if(res[i]==(int)(1e9))
                res[i]=-1;
        
        return res;
        
    }
}


// BFS part can also be implemented as follows
while(!q.isEmpty()){
    int size=q.size();
    for(int i=0;i<size;i++){
        int node=q.poll();
        for(int it:graph.get(node)){
            if(res[node]+1<res[it]){
                res[it]=res[node]+1;
                q.offer(it);
            }
        }
    }
}
        