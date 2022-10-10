class Solution {
    public List<Integer> eventualSafeNodes(int[][] G) {
        int n=G.length;
        boolean[] isSafe=new boolean[n];
        
        List<Set<Integer>> graph=new ArrayList<>();
        List<Set<Integer>> reverseGraph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new HashSet<>());
            reverseGraph.add(new HashSet<>());
        }
        
        Queue<Integer> q=new LinkedList<>();
        
        for(int i=0;i<n;i++){
            if(G[i].length==0)
                q.offer(i);
            for(int g : G[i]){
                graph.get(i).add(g);
                reverseGraph.get(g).add(i);
            }
        }
        
        while(!q.isEmpty()){
            int cur=q.poll();
            isSafe[cur]=true;
            for(int it:reverseGraph.get(cur)){
                graph.get(it).remove(cur);
                if(graph.get(it).isEmpty())
                    q.offer(it);
            }
        }
        
        
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<n;i++)
            if(isSafe[i])
                res.add(i);
        
        return res;
    }
}