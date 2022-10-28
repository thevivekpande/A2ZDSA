class Solution
{
    boolean[] isVis;
    int[] disc;
    int[] low;
    int[] parent;
    boolean[] articulationPoint;
    int timer;
    
    private void dfs(ArrayList<ArrayList<Integer>> adj, int node){
        isVis[node]=true;
        disc[node]=low[node]=++timer;
        int children=0;
        
        for(int it:adj.get(node)){
            if(!isVis[it]){
                children++;
                parent[it]=node;
                dfs(adj, it);
                low[node]=Math.min(low[node], low[it]);
                if((parent[node]==-1 && children>1) || (parent[node]!=-1 && low[it]>=disc[node])) articulationPoint[node]=true;
            }else if(it!=parent[node]){
                low[node]=Math.min(low[node], disc[it]);
            }
        }
    }
    
    //Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        ArrayList<Integer> res=new ArrayList<>();
        isVis=new boolean[V];
        disc=new int[V];
        low=new int[V];
        parent=new int[V];
        articulationPoint=new boolean[V];
        Arrays.fill(parent, -1);
        timer=0;
        
        for(int i=0;i<V;i++)
            if(!isVis[i])
                dfs(adj, i);
        
        for(int i=0;i<V;i++)
            if(articulationPoint[i]) res.add(i);
    
        if(res.size()==0) res.add(-1);
        
        return res;
    }
}