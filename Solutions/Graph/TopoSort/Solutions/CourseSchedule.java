class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        int m=prerequisites.length;
        List<List<Integer>> adj= new ArrayList<>();

        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
            
        for(int i=0;i<m;i++)
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        
        int[] inDegree=new int[n];
        for(int i=0;i<n;i++)
            for(int it:adj.get(i))
            inDegree[it]++;
            
        Queue<Integer> q=new LinkedList<>();
        int c=0;
        for(int i=0;i<n;i++)
            if(inDegree[i]==0)
                q.offer(i);
                
        while(!q.isEmpty()){
            int cur=q.poll();
            c++;
            for(int it:adj.get(cur)){
                inDegree[it]--;
                if(inDegree[it]==0) 
                    q.offer(it);
            }
        }
        
        return c==n;
    }
}