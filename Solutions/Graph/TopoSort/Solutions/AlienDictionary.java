// Solution 1: Using Topological sort (DFS)
// can also be solved using kahn's algo
class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<K;i++) graph.add(new ArrayList<>());
        
        for(int i=0;i<N-1;i++){
            String word1=dict[i];
            String word2=dict[i+1];
            for(int j=0;j<Math.min(word1.length(), word2.length());j++){
                if(word1.charAt(j)!=word2.charAt(j)){
                    graph.get(word1.charAt(j)-'a').add(word2.charAt(j)-'a');
                    break;
                }
            }
        }
        
        boolean[] isVis=new boolean[K];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<K;i++){
            if(!isVis[i]) dfs(i, graph, isVis, stack);
        }
        
        StringBuilder res=new StringBuilder();
        while(!stack.isEmpty())
            res.append((char)('a'+stack.pop()));
        
        return res.toString();
    }
    
    private void dfs(int node, ArrayList<ArrayList<Integer>> graph, boolean[] isVis, Stack<Integer> stack){
        isVis[node]=true;
        for(int it:graph.get(node))
            if(!isVis[it])
                dfs(it, graph, isVis, stack);
                
        stack.push(node);
    }
}

// Solution 2 : Same Solution without using stack
class Solution
{
    private String res;
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        res="";
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<K;i++) graph.add(new ArrayList<>());
        
        for(int i=0;i<N-1;i++){
            String word1=dict[i];
            String word2=dict[i+1];
            for(int j=0;j<Math.min(word1.length(), word2.length());j++){
                if(word1.charAt(j)!=word2.charAt(j)){
                    graph.get(word1.charAt(j)-'a').add(word2.charAt(j)-'a');
                    break;
                }
            }
        }
        
        boolean[] isVis=new boolean[K];
        
        for(int i=0;i<K;i++){
            if(!isVis[i]) dfs(i, graph, isVis);
        }
        
        return res;
    }
    
    private void dfs(int node, ArrayList<ArrayList<Integer>> graph, boolean[] isVis){
        isVis[node]=true;
        for(int it:graph.get(node))
            if(!isVis[it])
                dfs(it, graph, isVis);
                
        res=(char)(node+'a') + res;
    }
}