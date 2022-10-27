class DisjointSet{
    int[] parent;
    int[] size;
    int[] rank;
    
    DisjointSet(int n){
        parent=new int[n];
        size=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    
    int find(int i){
        if(parent[i]==i) return i;
        return parent[i]=find(parent[i]);
    }
    
    void unionBySize(int i, int j){
        i=find(i);
        j=find(j);
        if(i==j) return;
        if(size[i]<size[j]){
            parent[i]=j;
            size[j]+=size[i];
        }else{
            parent[j]=i;
            size[i]+=size[j];
        }
    }
    
    void unionByRank(int i, int j){
        i=find(i);
        j=find(j);
        if(i==j) return;
        if(rank[i]<rank[j]){
            parent[i]=j;
        }else if(rank[i]>rank[j]){
            parent[j]=i;
        }else{
            parent[j]=i;
            rank[i]++;
        }
    }
}

class Solution {
    int[][] dirs=new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        DisjointSet ds=new DisjointSet(n*n);
        
        int start=grid[0][0], end=grid[n-1][n-1];
        
        int[] time=new int[n*n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                time[grid[i][j]]=i*n+j;
            }
        }
        
        for(int t=0;t<n*n;t++){
            int row=time[t]/n;
            int col=time[t]-row*n;
            for(int[] dir:dirs){
               int x=dir[0]+row;
               int y=dir[1]+col;
               if(x<0 || y<0 || x>=n || y>=n || grid[x][y]>t) continue;
                    ds.unionByRank(t, grid[x][y]);
               }
            if(ds.find(start)==ds.find(end)) return t;
        }
        return (n*n)-1;
    }
}