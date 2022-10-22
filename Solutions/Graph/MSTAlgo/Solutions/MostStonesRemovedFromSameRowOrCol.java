class Solution {
    public int removeStones(int[][] stones) {
        Set<int[]> isVis=new HashSet<>();
        int count=0;
        for(int[] stone: stones){
            if(!isVis.contains(stone)){
                count++;
                dfs(stone, stones, isVis);
            }
        }
        return stones.length-count;
    }
    private void dfs(int[] stone, int[][] stones, Set<int[]> isVis){
        isVis.add(stone);
        for(int[] it:stones){
            if(!isVis.contains(it) && (it[0]==stone[0] || it[1]==stone[1]))
                dfs(it, stones, isVis);
        }
    }
}