// LeetCode sol 1
class Solution {
    private void solve(int col, char[][] board, List<List<String>> res){
        if(col==board.length){
            res.add(construct(board));
            return;
        }
        
        for(int row=0;row<board.length;row++){
            if(isSafe(board, row, col)){
                board[row][col]='Q';
                solve(col+1, board, res);
                board[row][col]='.';
            }
        }
    }
    
    private boolean isSafe(char[][] board, int row, int col){
        int tempRow=row, tempCol=col;
        int m=board.length, n=board.length;
        while(row>=0 && col>=0){
            if(board[row][col]=='Q') return false;
            row--;
            col--;
        }
        
        row=tempRow; col=tempCol;
        while(col>=0 && row<n){
            if(board[row][col]=='Q') return false;
            row++;
            col--;
        }
        
        row=tempRow; col=tempCol;
        while(col>=0){
            if(board[row][col]=='Q') return false;
            col--;
        }
        
        return true;
    }
    
    private List<String> construct(char[][] board){
        List<String> res=new ArrayList();
        
        for(char[] row:board)
            res.add(new String(row));
        
        return res;
    }
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList();
        char[][] board=new char[n][n];
        for(char[] row:board)
            Arrays.fill(row, '.');
        solve(0, board, res);
        return res;
    }
}

// Leetcode sol 2
class Solution {
    private void solve(int row, char[][] board, List<List<String>> res){
        if(row==board.length){
            res.add(construct(board));
            return;
        }
        
        for(int col=0;col<board.length;col++){
            if(isSafe(board, row, col)){
                board[row][col]='Q';
                solve(row+1, board, res);
                board[row][col]='.';
            }
        }
    }
    
    private boolean isSafe(char[][] board, int row, int col){
        int tempRow=row, tempCol=col;
        int m=board.length, n=board.length;
        while(row>=0 && col>=0){
            if(board[row][col]=='Q') return false;
            row--;
            col--;
        }
        
        row=tempRow; col=tempCol;
        while(row>=0 && col<n){
            if(board[row][col]=='Q') return false;
            row--;
            col++;
        }
        
        row=tempRow; col=tempCol;
        while(row>=0){
            if(board[row][col]=='Q') return false;
            row--;
        }
        
        return true;
    }
    
    private List<String> construct(char[][] board){
        List<String> res=new ArrayList();
        
        for(char[] row:board)
            res.add(new String(row));
        
        return res;
    }
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList();
        char[][] board=new char[n][n];
        for(char[] row:board)
            Arrays.fill(row, '.');
        solve(0, board, res);
        return res;
    }
}

// GFG
class Solution{
    private static void solve(int row, boolean[][] board, ArrayList<ArrayList<Integer>> res){
        if(row==board.length){
            res.add(construct(board));
            return;
        }
        
        for(int col=0;col<board.length;col++){
            if(isSafe(board, row, col)){
                board[row][col]=true;
                solve(row+1, board, res);
                board[row][col]=false;
            }
        }
    }
    
    private static boolean isSafe(boolean[][] board, int row, int col){
        int tempRow=row, tempCol=col;
        int m=board.length;
        
        while(row>=0 && col>=0){
            if(board[row][col])
                return false;
            row--;
            col--;
        }
        
        row=tempRow; col=tempCol;
        while(col<m && row>=0){
            if(board[row][col])
                return false;
            row--;
            col++;
        }
        
        row=tempRow; col=tempCol;
        while(row>=0){
            if(board[row][col])
                return false;
            row--;
        }
        
        return true;
    }
    
    private static ArrayList<Integer> construct(boolean[][] board){
        ArrayList<Integer> res=new ArrayList<>();;
        int m=board.length;
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]) res.add(j+1);
            }
        }
        return res;
    }
    
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        boolean[][] board=new boolean[n][n];
        solve(0, board, res);
        Collections.sort(res, (a, b)->(a.get(0)-b.get(0)));
        return res;
    }
}