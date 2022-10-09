class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] isVis=new boolean[V];
        for(int i=0;i<V;i++)
            if(!isVis[i] && detectCycle(i, -1, adj, isVis)) return true;
        return false;
    }
    
    private boolean detectCycle(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] isVis){
        isVis[node]=true;
        for(int it:adj.get(node)){
            if(!isVis[it]){
                if(detectCycle(it, node, adj, isVis)) return true;
            }else if(it!=parent) return true;
        }
        return false;
    }
}