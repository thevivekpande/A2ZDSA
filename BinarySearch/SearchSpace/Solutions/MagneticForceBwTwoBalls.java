class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n=position.length;
        int left=1, right=position[n-1]-position[0];
        while(left<=right){
            int mid=left+((right-left)>>1);
            boolean isPos=isPossible(position, mid, m);
            if(isPos)
                left=mid+1;
            else
                right=mid-1;
        }
        return right;
    }
    private boolean isPossible(int[] arr, int limit, int magnet){
        int count=1;
        int lastPos=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]-lastPos>=limit){
                count++;
                lastPos=arr[i];
            }
            if(count==magnet) return true;
        }
        return false;
    }
}