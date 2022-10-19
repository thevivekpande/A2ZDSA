class Solution 
{ 
    boolean res=false;
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) 
    { 
        // code here
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=N;i++)
            graph.add(new ArrayList<Integer>());
            
        for(ArrayList<Integer> edge: Edges){
            graph.get(edge.get(0)).add(edge.get(1));
            graph.get(edge.get(1)).add(edge.get(0));
        }
        
        for(int i=1;i<=N;i++){
            dfs(graph, i, 0, new int[N+1]);
            if(res) return true;
        }
        
        return false;
    }
    
    private void dfs(ArrayList<ArrayList<Integer>> graph, int i, int c, int[] temp){
        if(c==graph.size()-1){
            res=true;
            return;
        }
        
        for(int it:graph.get(i)){
            if(temp[it]!=1){
                temp[it]++;
                dfs(graph, it, c+1, temp);
                temp[it]--;
            }
        }
    }
} 