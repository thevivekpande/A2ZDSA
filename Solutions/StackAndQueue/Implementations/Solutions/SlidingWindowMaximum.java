class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        Deque<Integer> q=new ArrayDeque<>();
        int[] res=new int[n-k+1];
        int c=0;
        for(int i=0;i<n;i++){
            // check if last element is out of range
            if(!q.isEmpty() && i-k==q.peek()) q.poll();
            // remove any element lesser and equal to current, because it has no use
            while(!q.isEmpty() && nums[q.peekLast()]<=nums[i]) q.pollLast();
            q.offer(i);
            if(i>=k-1) res[c++]=nums[q.peek()];
        }
        return res;
    }
}