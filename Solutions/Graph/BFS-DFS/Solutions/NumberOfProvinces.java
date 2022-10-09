// Leetcode
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int res=0;
        int n=isConnected.length;
        boolean[] isVis=new boolean[n];
        
        for(int i=0;i<n;i++)
            if(!isVis[i]){
                res++;
                dfs(i, isConnected, isVis);
            }
        
        return res;
    }
    
    private void dfs(int node, int[][] isConnected, boolean[] isVis){
        isVis[node]=true;
        int n=isConnected.length;
        for(int i=0;i<n;i++)
            if(isConnected[node][i]==1 && !isVis[i])
                dfs(i, isConnected, isVis);
    }
}


// GeeksForGeeks
class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        int res=0;
        boolean[] isVis=new boolean[V];
        
        for(int i=0;i<V;i++)
            if(!isVis[i]){
                res++;
                dfs(i, adj, isVis, V);
            }
        
        return res;
    }
    
    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] isVis, int V){
        isVis[node]=true;
        for(int i=0;i<V;i++)
            if(adj.get(node).get(i)==1 && !isVis[i])
                dfs(i, adj, isVis, V);
    }
};