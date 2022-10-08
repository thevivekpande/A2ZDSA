class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> a, int V) {
        // code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        
        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());
            
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(i!=j && a.get(i).get(j)==1)
                    adj.get(i).add(j);
            }
        }
        
        int res=0;
            
        boolean[] isVis=new boolean[V];
        for(int i=0;i<V;i++){
            if(!isVis[i]){
                res++;
                dfs(adj, i, isVis);
            }
        }
        
        return res;
        
    }
    
    private static void dfs(ArrayList<ArrayList<Integer>> adj, int node, boolean[] isVis){
        isVis[node]=true;
        for(int it: adj.get(node))
            if(!isVis[it])
                dfs(adj, it, isVis);
    }
};