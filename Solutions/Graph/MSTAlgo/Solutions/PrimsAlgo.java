class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        // Add your code here
        int res=0;
        boolean[] isVis=new boolean[V];
        PriorityQueue<int[]> heap=new PriorityQueue<>((a, b)->a[1]-b[1]);
        heap.offer(new int[]{0, 0});
        while(!heap.isEmpty()){
            int[] top=heap.poll();
            int cur=top[0], wt=top[1];
            if(isVis[cur]) continue;
            isVis[cur]=true;
            res+=wt;
            for(ArrayList<Integer> it:adj.get(cur)){
                int next=it.get(0);
                int nextWt=it.get(1);
                if(!isVis[next])
                    heap.offer(new int[]{next, nextWt});
            }
        }
        return res;
    }
}
