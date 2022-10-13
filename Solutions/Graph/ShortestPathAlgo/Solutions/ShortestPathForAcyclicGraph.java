class Pair{
    int node;
    int weight;
    Pair(int _node, int _weight){
        node=_node;
        weight=_weight;
    }
}
//User function Template for Java
class Solution {
    
    private void topoSort(int node, boolean[] isVis, Stack<Integer> stack, ArrayList<ArrayList<Pair>> graph){
        isVis[node]=true;
        for(Pair p:graph.get(node)){
            if(!isVis[p.node])
                topoSort(p.node, isVis, stack, graph);
        }
        stack.push(node);
    }

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		ArrayList<ArrayList<Pair>> graph=new ArrayList<>();
		for(int i=0;i<N;i++)
		    graph.add(new ArrayList<>());
		   
		for(int[] edge:edges)
		    graph.get(edge[0]).add(new Pair(edge[1], edge[2]));
		   
		Stack<Integer> stack=new Stack<>();
		boolean[] isVis=new boolean[N];
		
		for(int i=0;i<N;i++)
		    if(!isVis[i])
		        topoSort(i, isVis, stack, graph);
		
		int[] res=new int[N];
		Arrays.fill(res, (int)(1e9));
		res[0]=0;
		
		while(!stack.isEmpty()){
		    int node=stack.pop();
		    for(Pair it : graph.get(node)){
		        int v=it.node;
		        int wt=it.weight;
		        if((res[node]+wt)<(res[v])){
		            res[v]=res[node]+wt;
		        }
		    }
		}
		
		for(int i=0;i<N;i++)
		    if(res[i] == (int)(1e9))
		        res[i]=-1;
		
		return res;
		
	}
}