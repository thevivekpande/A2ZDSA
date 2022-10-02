class solve {
    private boolean isSafe(boolean[][] graph, int curV, int assignedColor, int[] color, int n){
        for(int i=0;i<n;i++){
            if(graph[curV][i] && color[i]==assignedColor)
                 return false;
        }
        return true;
    }
    
    private boolean backTrack(int curV, boolean[][] graph, int[] color, int m, int n){
        if(curV==n){
            return true;
        }
        
        for(int i=0;i<m;i++){
            if(isSafe(graph, curV, i, color, n)){
                color[curV]=i;
                if(backTrack(curV+1, graph, color, m, n)) return true;
                color[curV]=-1;
            }
        }
        
        return false;
    }
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        int[] color=new int[n];
        Arrays.fill(color, -1);
        return backTrack(0, graph, color, m, n);
    }
}