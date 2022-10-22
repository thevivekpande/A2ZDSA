class Solution
{
    private static int find(int i, int[] parent){
        if(parent[i]==i) return i;
        return parent[i]=find(parent[i], parent);
    }
    
    private static void union(int i, int j, int[] rank, int[] parent){
        i=find(i, parent);
        j=find(j, parent);
        if(rank[i]<rank[j]){
            parent[i]=j;
        }else if(rank[j]<rank[i]){
            parent[j]=i;
        }else{
            parent[i]=j;
            rank[j]++;
        }
    }
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        // Add your code here
        int[] rank=new int[V];
        int[] parent=new int[V];
        for(int i=0;i<V;i++)
            parent[i]=i;
        
        ArrayList<int[]> edges=new ArrayList<>();
        for(int i=0;i<V;i++){
            for(ArrayList<Integer> a : adj.get(i)){
                edges.add(new int[]{i, a.get(0), a.get(1)});
            }
        }
        
        Collections.sort(edges, (a, b)->a[2]-b[2]);
        int res=0;
        for(int[] edge:edges){
            if(find(edge[0], parent)!=find(edge[1], parent)){
                res+=edge[2];
                union(edge[0], edge[1], rank, parent);
            }
        }
        
        return res;
    }
}

