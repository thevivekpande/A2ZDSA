class Solution {
    int timer;
    List<List<Integer>> res;
    boolean[] isVis;
    int[] timeStamp;
    
    private void criticalConnectionsUtil(List<List<Integer>> graph, int node, int par){
        isVis[node]=true;
        timeStamp[node]=timer++;
        int curTimeStamp=timeStamp[node];
        
        for(int it:graph.get(node)){
            if(it==par) continue;
            if(!isVis[it]) criticalConnectionsUtil(graph, it, node);
            timeStamp[node]=Math.min(timeStamp[node], timeStamp[it]);
            if(curTimeStamp<timeStamp[it]) res.add(Arrays.asList(node, it));
        }
    }
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++)
            graph.add(new ArrayList<>());
        
        for(List<Integer> edge : connections){
            graph.get(edge.get(0)).add(edge.get(1));
            graph.get(edge.get(1)).add(edge.get(0));
        }
        
        timer=0;
        res=new ArrayList<>();
        isVis=new boolean[n];
        timeStamp=new int[n];
        
        criticalConnectionsUtil(graph, 0, -1);
        
        return res;
    }
}