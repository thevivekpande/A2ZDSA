class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> res=new ArrayList<>();
        boolean[] isVis=new boolean[V];
        for(int i=0;i<V;i++){
            if(!isVis[i])
                dfs(adj, i, res, isVis);
        }
        return res;
    }
    
    private void dfs(ArrayList<ArrayList<Integer>> adj, int node, ArrayList<Integer> res, boolean[] isVis){
        isVis[node]=true;
        res.add(node);
        for(int it:adj.get(node))
            if(!isVis[it])
            dfs(adj, it, res, isVis);
    }
}