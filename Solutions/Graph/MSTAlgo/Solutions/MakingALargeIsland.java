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
    
    void unionByRank(int i, int j){
        i=find(i);
        j=find(j);
        if(i==j) return;
        if(rank[i]<rank[j]){
            parent[i]=j;
        }else if(rank[j]<rank[i]){
            parent[j]=i;
        }else{
            parent[j]=i;
            rank[i]++;
        }
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
}

class Solution {
    int[][] dirs=new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public int MaxConnection(int grid[][]) {
        //Your code here
        int n=grid.length;
        DisjointSet ds=new DisjointSet(n*n);
        
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col]==0) continue;
                for(int i=0;i<4;i++){
                    int x=dirs[i][0]+row;
                    int y=dirs[i][1]+col;
                    if(x<0 || y<0 || x>=n || y>=n || grid[x][y]==0) continue;
                    int curNode=row*n+col;
                    int newNode=x*n+y;
                    ds.unionBySize(curNode, newNode);
                }
            }
        }
        
        int max=0;
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col]==1) continue;
                HashSet<Integer> components=new HashSet<>();
                for(int i=0;i<4;i++){
                    int x=dirs[i][0]+row;
                    int y=dirs[i][1]+col;
                    if(x<0 || y<0 || x>=n || y>=n || grid[x][y]==0) continue;
                    components.add(ds.find(x*n+y));
                }
            int totalSize=0;
            for(Integer i : components)
                totalSize+=ds.size[i];
            max=Math.max(max, totalSize+1);
            }
        }
        
        for(int i=0;i<n*n;i++)
            max=Math.max(max, ds.size[ds.find(i)]);
        
        return max;
    }
}