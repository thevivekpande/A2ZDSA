class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        int res=0, last=0;
        int[][] meetings=new int[n][2];
        for(int i=0;i<n;i++){
            meetings[i][0]=start[i];
            meetings[i][1]=end[i];
        }
        Arrays.sort(meetings, (a,b)->a[1]-b[1]);
        for(int i=0;i<n;i++){
            if(meetings[i][0]>last){
                last=meetings[i][1];
                res++;
            }
        }
        return res;
    }
}
