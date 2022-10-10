class Solution
{
    private static void dfs(int node, Stack<Integer> stack, boolean[] isVis, ArrayList<ArrayList<Integer>> adj){
        isVis[node]=true;
        for(int it:adj.get(node))
            if(!isVis[it])
                dfs(it, stack, isVis, adj);
        stack.push(node);
    }
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        int[] res=new int[V];
        Stack<Integer> stack=new Stack<>();
        boolean[] isVis=new boolean[V];
        
        for(int i=0;i<V;i++)
            if(!isVis[i])
                dfs(i, stack, isVis, adj);
        
        int c=0;
        while(!stack.isEmpty()) res[c++]=stack.pop();
        
        return res;
    }
}


