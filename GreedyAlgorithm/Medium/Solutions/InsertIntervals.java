class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res=new ArrayList<>();
        int n=intervals.length, i=0;
        
        while(i<n && intervals[i][1]<newInterval[0])
            res.add(intervals[i++]);
        
        while(i<n && newInterval[1]>=intervals[i][0]){
            newInterval[0]=Math.min(newInterval[0], intervals[i][0]);
            newInterval[1]=Math.max(newInterval[1], intervals[i++][1]);
        }
        res.add(newInterval);

        while(i<n)
            res.add(intervals[i++]);
                
        int[][] ans=new int[res.size()][2];
        for(i=0;i<res.size();i++){
            ans[i]=res.get(i);
        }
        
        return ans;
    }
}