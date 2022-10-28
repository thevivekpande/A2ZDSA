//User function Template for Java
class Solution
{
    Stack<Integer> stack;
    boolean[] isVis;
    ArrayList<ArrayList<Integer>> transpose;
    
    private void topoSort(int node, ArrayList<ArrayList<Integer>> adj){
        isVis[node]=true;
        for(Integer it:adj.get(node)){
            if(!isVis[it])
                topoSort(it, adj);
        }
        stack.push(node);
    }
    
    private void reverse(int V, ArrayList<ArrayList<Integer>> adj){
        for(int i=0;i<V;i++){
            for(int it : adj.get(i))
                transpose.get(it).add(i);
        }
    }
    
    
    private void dfs(int node){
        isVis[node]=true;
        for(Integer it:transpose.get(node))
            if(!isVis[it])
                dfs(it);
    }
    
    
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        stack=new Stack<>();
        isVis=new boolean[V];
        transpose=new ArrayList<>();
        for(int i=0;i<V;i++)
            transpose.add(new ArrayList<>());
            
        // DFS1 (Topo Sort)
        for(int i=0;i<V;i++){
            if(!isVis[i])
                topoSort(i, adj);
        }
        
        // Transpose of graph
        reverse(V, adj);
        
        Arrays.fill(isVis, false);
        // DFS2
        int res=0;
        while(!stack.isEmpty()){
            int node=stack.pop();
            if(!isVis[node]){
                res++;
                dfs(node);
            }
        }
        
        return res;
    }
}