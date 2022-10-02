class Solution {    
    private boolean dfs(int ind, int i, int j, int m, int n, char[][] board, char[] word){
        
        if(ind==word.length) return true;
        
        if(i<0 || j<0 || i>=m || j>=n || board[i][j]!=word[ind]) return false;
        
        char ch=board[i][j];
        board[i][j]='@';
        
        boolean up=dfs(ind+1, i+1, j, m, n, board, word);
        boolean down=dfs(ind+1, i-1, j, m, n, board, word);
        boolean left=dfs(ind+1, i, j-1, m, n, board, word);
        boolean right=dfs(ind+1, i, j+1, m, n, board, word);
        
        board[i][j]=ch;
        
        return up||down||left||right;        
    }
    
    public boolean exist(char[][] board, String word) {
        int m=board.length, n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    if(dfs(0, i, j, m, n, board, word.toCharArray())) return true;
                }
            }
        }
        return false;
    }
}