// User function Template for Java

class Solution
{
    private static void dfs(boolean[] isVis, int node, ArrayList<ArrayList<Integer>> graph){
        isVis[node]=true;
        for(int it:graph.get(node))
            if(!isVis[it])
                dfs(isVis, it, graph);
    }
    
    //Function to find if the given edge is a bridge in graph.
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {
        // code here
        boolean[] isVis=new boolean[V];
        int count1=0;
        for(int i=0;i<V;i++){
            if(!isVis[i]){
                count1++;
                dfs(isVis, i, adj);
            }
        }
        
        adj.get(c).remove(Integer.valueOf(d));
        adj.get(d).remove(Integer.valueOf(c));
        
        Arrays.fill(isVis, false);
        int count2=0;
        for(int i=0;i<V;i++){
            if(!isVis[i]){
                count2++;
                dfs(isVis, i, adj);
            }
        }
        return count2>count1?1:0;
    }
}