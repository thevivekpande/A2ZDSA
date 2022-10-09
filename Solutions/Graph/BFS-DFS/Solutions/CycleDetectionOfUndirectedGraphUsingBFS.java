// Solution 1
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] isVis=new boolean[V];
        for(int i=0;i<V;i++)
            if(!isVis[i] && detectCycle(i, -1, adj, isVis)) return true;
        return false;
    }
    
    private boolean detectCycle(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] isVis){
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{node, parent});
        isVis[node]=true;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] cur=q.poll();
                int nod=cur[0];
                int par=cur[1];
                for(int it:adj.get(nod)){
                    if(!isVis[it]){
                        isVis[it]=true;
                        q.offer(new int[]{it, nod});
                    }else if(it!=par) return true;
                }
            }
        }
        return false;
    }
}


// Solution 2
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] isVis=new boolean[V];
        for(int i=0;i<V;i++)
            if(!isVis[i] && detectCycle(i, -1, adj, isVis)) return true;
        return false;
    }
    
    private boolean detectCycle(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] isVis){
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{node, parent});
        isVis[node]=true;
        while(!q.isEmpty()){
                int[] cur=q.poll();
                int nod=cur[0];
                int par=cur[1];
                for(int it:adj.get(nod)){
                    if(!isVis[it]){
                        isVis[it]=true;
                        q.offer(new int[]{it, nod});
                    }else if(it!=par) return true;
                }
        }
        return false;
    }
}