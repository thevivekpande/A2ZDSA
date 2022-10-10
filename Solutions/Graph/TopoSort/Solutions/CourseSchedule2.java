// Leetcode Solution 1
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree=new int[numCourses];
        for(int[] pre : prerequisites)
            inDegree[pre[0]]++;
        
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++)
            if(inDegree[i]==0)
                q.offer(i);
        
        int c=0;
        int[] res=new int[numCourses];
        while(!q.isEmpty()){
            int cur=q.poll();
            res[c++]=cur;
            for(int[] pre : prerequisites){
                if(pre[1]==cur){
                    inDegree[pre[0]]--;
                    if(inDegree[pre[0]]==0) q.offer(pre[0]);
                }
            }
        }
        
        return c==numCourses?res:new int[0];
    }
}

// Leetcode Solution 2
class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
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
        int[] res=new int[n];
        int c=0;
        for(int i=0;i<n;i++)
            if(inDegree[i]==0)
                q.offer(i);
                
        while(!q.isEmpty()){
            int cur=q.poll();
            res[c++]=cur;
            for(int it:adj.get(cur)){
                inDegree[it]--;
                if(inDegree[it]==0) 
                    q.offer(it);
            }
        }
        
        return c==n?res:new int[0];

    }
}

// GeeksforGeeks
class Solution
{
    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) 
    {
        // add your code here
        List<List<Integer>> adj= new ArrayList<>();

        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
            
        for(int i=0;i<m;i++)
            adj.get(prerequisites.get(i).get(1)).add(prerequisites.get(i).get(0));
        
        int[] inDegree=new int[n];
        for(int i=0;i<n;i++)
            for(int it:adj.get(i))
            inDegree[it]++;
            
        Queue<Integer> q=new LinkedList<>();
        int[] res=new int[n];
        int c=0;
        for(int i=0;i<n;i++)
            if(inDegree[i]==0)
                q.offer(i);
                
        while(!q.isEmpty()){
            int cur=q.poll();
            res[c++]=cur;
            for(int it:adj.get(cur)){
                inDegree[it]--;
                if(inDegree[it]==0) 
                    q.offer(it);
            }
        }
        
        return c==n?res:new int[0];
    }
}