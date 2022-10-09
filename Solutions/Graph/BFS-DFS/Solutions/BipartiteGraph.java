// Leetcode (DFS)
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        Arrays.fill(color, -1);
        for(int i=0;i<n;i++)
            if(color[i]==-1 && !dfs(i, 0, graph, color)) 
                return false;
        return true;
    }
    private boolean dfs(int node, int clr, int[][] graph, int[] color){
        color[node]=clr;
        for(int it:graph[node]){
            if(color[it]==-1 && !dfs(it, 1-clr, graph, color))
                return false;
            else if(color[it]==color[node]) 
                return false;
        }
        return true;
    }
}

// GeeksForGeeks (DFS)
class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int[] color=new int[V];
        Arrays.fill(color, -1);
        for(int i=0;i<V;i++){
            if(color[i]==-1){
                if(!dfs(i, 0, adj, color)) return false;
            }
        }
        return true;
    }
    
    private boolean dfs(int node, int clr, ArrayList<ArrayList<Integer>> adj, int[] color){
        color[node]=clr;
        for(int it:adj.get(node)){
            if(color[it]==-1 && !dfs(it, 1-clr, adj, color)) return false;
            else if(color[it]==color[node]) return false;
        }
        return true;
    }
}