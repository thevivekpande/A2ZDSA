class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1) return -1;
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++)
            graph.add(new ArrayList<>());
        for(int[] connection : connections){
            graph.get(connection[0]).add(connection[1]);
            graph.get(connection[1]).add(connection[0]);
        }
        
        boolean[] isVis=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!isVis[i]){
                dfs(i, graph, isVis);
                count++;
            }
        }
        return count-1;
    }
    private void dfs(int node, ArrayList<ArrayList<Integer>> graph, boolean[] isVis){
        isVis[node]=true;
        for(int it : graph.get(node))
            if(!isVis[it])
                dfs(it, graph, isVis);
    }
}