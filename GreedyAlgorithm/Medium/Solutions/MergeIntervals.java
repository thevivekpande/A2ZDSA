class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        List<int[]> list=new ArrayList<>();
        int i=0, n=intervals.length;
        
        while(i<n){
            int start=intervals[i][0];
            int last=intervals[i][1];
            while(i<n-1 && last>=intervals[i+1][0])
                last=Math.max(last, intervals[++i][1]);
            i++;
            list.add(new int[]{start, last});
        }
        
        int[][] res=new int[list.size()][2];
        for(i=0;i<res.length;i++)
            res[i]=list.get(i);
        
        return res;
    }
}