class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int clr=image[sr][sc];
        if(clr!=color)
            dfs(image, sr, sc, clr, color);
        return image;
    }
    
    private void dfs(int[][] image, int x, int y, int color, int newColor){
        int m=image.length, n=image[0].length;
        if(x<0 || y<0 || x>=m || y>=n || image[x][y]!=color) return;
        image[x][y]=newColor;
        dfs(image, x+1, y, color, newColor);
        dfs(image, x, y+1, color, newColor);
        dfs(image, x, y-1, color, newColor);
        dfs(image, x-1, y, color, newColor);
    }
}