class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> res=new ArrayList<>();
        boolean[] isVis=new boolean[V];
        Queue<Integer> q=new LinkedList<>();
        q.offer(0);
        isVis[0]=true;
        while(!q.isEmpty()){
            int node=q.poll();
            res.add(node);
            for(int i:adj.get(node)){
                if(!isVis[i]){
                    isVis[i]=true;
                    q.offer(i);
                }
            }
        }
        return res;
    }
}