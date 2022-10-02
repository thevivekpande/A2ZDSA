class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);
        int maxDeadline=0;
        for(Job i: arr)
            maxDeadline=Math.max(maxDeadline, i.deadline);
        int[] isOcc=new int[maxDeadline+1];
        int profit=0, totalDays=0;
        for(int i=0;i<n;i++){
            for(int j=arr[i].deadline;j>0;j--){
                if(isOcc[j]==0){
                    isOcc[j]=1;
                    totalDays++;
                    profit+=arr[i].profit;
                    break;
                }
            }
        }
        return new int[]{totalDays, profit};
    }
}
