class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        int[] res=new int[V];
        Arrays.fill(res, (int)1e8);
        res[S]=0;
        for(int i=0;i<=V;i++){
            for(ArrayList<Integer> edge:edges){
                int u=edge.get(0);
                int v=edge.get(1);
                int w=edge.get(2);
                if(res[u]==((int) 1e8)) continue;
                if(res[u]+w<res[v]){
                    if(V==i){
                        return new int[]{-1};
                    }
                    res[v]=res[u]+w;
                }
            }
        }
        return res;
    }
}
