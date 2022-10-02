class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1]-b[1]);
        int i=0, n=intervals.length, count=1;
        int last=intervals[0][1];
        for(i=1;i<n;i++){
            if(intervals[i][0]>=last){
                count++;
                last=intervals[i][1];
            }
        }
        return n-count;
    }
}