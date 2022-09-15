class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->(a[0]-b[0]));
        List<int[]> list=new ArrayList();
        int i=0, n=intervals.length;
        while(i<n){
            int start=intervals[i][0];
            int last=intervals[i][1];
            
            while(i+1<n && last>=intervals[i+1][0]){
                last=Math.max(last, intervals[++i][1]) ;
            }
            
            i++;
            list.add(new int[]{start, last});
        }
        
        return list.toArray(new int[list.size()][]);
    }
}