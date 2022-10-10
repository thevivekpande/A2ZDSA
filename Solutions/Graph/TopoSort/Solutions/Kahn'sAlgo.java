class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        int[] inDegree=new int[V];
        for(int i=0;i<V;i++){
            for(int it:adj.get(i))
                inDegree[it]++;
        }
        
        Queue<Integer> q=new LinkedList<>();
        int[] res=new int[V];
        int c=0;
        
        for(int i=0;i<V;i++)
            if(inDegree[i]==0) q.offer(i);
            
        while(!q.isEmpty()){
            int cur=q.poll();
            res[c++]=cur;
            for(int it:adj.get(cur)){
                inDegree[it]--;
                if(inDegree[it]==0){
                    q.offer(it);
                }
            }
        }
        
        return res;
    }
}
