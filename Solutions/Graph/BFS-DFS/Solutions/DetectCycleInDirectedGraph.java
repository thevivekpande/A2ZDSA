// using DFS
class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] isVis=new boolean[V];
        boolean[] dfsVis=new boolean[V];
        
        for(int i=0;i<V;i++)
            if(!isVis[i])
                if(dfs(i, isVis, dfsVis, adj)) return true;
        
        return false;
    }
    
    private boolean dfs(int node, boolean[] isVis, boolean[] dfsVis, ArrayList<ArrayList<Integer>> adj){
        isVis[node]=true;
        dfsVis[node]=true;
        for(int it:adj.get(node)){
            if(!isVis[it]){
                if(dfs(it, isVis, dfsVis, adj)) return true;
            }else if(dfsVis[it]) return true;
        }
        dfsVis[node]=false;
        return false;
    }
}

// Using BFS | Kahn's Algo | Topo Sort
// A cyclic directed graph cannot generate Topological sort
class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] inDegree=new int[V];
        for(int i=0;i<V;i++){
            for(int it:adj.get(i))
            inDegree[it]++;
        }
        
        Queue<Integer> q=new LinkedList<>();
        
        for(int i=0;i<V;i++){
            if(inDegree[i]==0)
                q.offer(i);
        }
        
        int cnt=0;
        while(!q.isEmpty()){
            int cur=q.poll();
            for(int it:adj.get(cur)){
                inDegree[it]--;
                if(inDegree[it]==0){
                    q.offer(it);
                }
            }
            cnt++;
        }
        
        return cnt!=V;
    }
}