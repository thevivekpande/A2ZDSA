class Pair{
    int node;
    int weight;
    Pair(int _node, int _weight){
        node=_node;
        weight=_weight;
    }
}

class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int src)
    {
        // Write your code here
        int[] res=new int[V];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[src]=0;
        
        PriorityQueue<Pair> heap=new PriorityQueue<>((a, b) -> a.weight==b.weight?a.node-b.node:a.weight-b.weight);
        heap.offer(new Pair(src, 0));
        
        while(!heap.isEmpty()){
            Pair cur=heap.poll();
            int node=cur.node;
            int wt=cur.weight;
            
            for(ArrayList<Integer> it:adj.get(node)){
                int edgeWt=it.get(1);
                int adjNode=it.get(0);
                if(wt+edgeWt<res[adjNode]){
                    res[adjNode]=edgeWt+wt;
                    heap.offer(new Pair(adjNode, edgeWt+wt));
                }
            }
        }
        
        return res;
    }
}

