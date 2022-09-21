
// m is the given matrix and n is the order of matrix
class Solution {
    static int[][] dirs=new int[][]{ {-1,0},  {0,-1}, {0, 1}, {1, 0} };
    
    private static void solve(int i, int j, int[][] mat, int n, ArrayList<String> res, boolean[][] isVis, String cur){
        if(i==n-1 && j==n-1) {
            res.add(cur);
            return;
        }
        
        String dir="ULRD";
        
        for(int ii=0;ii<4;ii++){
            int x=dirs[ii][0]+i;
            int y=dirs[ii][1]+j;
            if(x<0 || x>=n || y<0 || y>=n || mat[x][y]==0 || isVis[x][y]) continue;
            isVis[x][y]=true;
            solve(x, y, mat, n, res, isVis, cur+(dir.charAt(ii)));
            isVis[x][y]=false;
        }
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> res=new ArrayList<>();
        boolean[][] isVis=new boolean[n][n];
        isVis[0][0]=true;
        if(m[0][0]==1) solve(0, 0, m, n, res, isVis, "");
        return res;
    }
}