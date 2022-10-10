// Using BFS | Kahn's Algo
// A cyclic directed graph will never form a topological sort
class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] inDegree=new int[V];
        for(int i=0;i<V;i++){
            for(int it:adj.get(i))
            inDegree[it]++;
        }
        
        Queue<Integer> q=new LinkedList<>();
        
        for(int i=0;i<V;i++){
            if(inDegree[i]==0)
                q.offer(i);
        }
        
        int cnt=0;
        while(!q.isEmpty()){
            int cur=q.poll();
            for(int it:adj.get(cur)){
                inDegree[it]--;
                if(inDegree[it]==0){
                    q.offer(it);
                }
            }
            cnt++;
        }
        
        return cnt!=V;
    }
}