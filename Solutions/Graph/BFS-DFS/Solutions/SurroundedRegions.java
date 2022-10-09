/*

use dfs from extreme boundaries (rows and columns both), 
and mark all 'O's which are connected from boundary to any random character (let's say '@'),
since these 'O's are connected to boundaries so they can't be covered from all the sides.
so, now flip all '@' to 'O' since these are connected to the boundaries, and all 'O's to 'X'.

*/
class Solution {
    public void dfs(int i, int j, char[][] board){
        int m=board.length, n=board[0].length;
        if(i<0 || j<0 || i>=m || j>=n || board[i][j]!='O') return;
        board[i][j]='@';
        dfs(i+1, j, board);
        dfs(i-1, j, board);
        dfs(i, j+1, board);
        dfs(i, j-1, board);
    }
    public void solve(char[][] board) {
        int m=board.length, n=board[0].length;
        
        // row boundary dfs
        for(int i=0;i<m;i++){
            if(board[i][0]=='O') 
                dfs(i, 0, board);
            if(board[i][n-1]=='O')
                dfs(i, n-1, board);
        }
        
        //column boundary dfs
        for(int i=0;i<n;i++){
            if(board[0][i]=='O')
                dfs(0, i, board);
            if(board[m-1][i]=='O')
                dfs(m-1, i, board);
        }
        
        // flip accoringly
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O') board[i][j]='X';
                if(board[i][j]=='@') board[i][j]='O';
            }
        }
    }
}