class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left=0, right=0;
        for(int i:nums)
            right=Math.max(i, right);
        while(left<=right){
            int mid=left+((right-left)>>1);
            int count=0;
            for(double i : nums)
                count+=Math.ceil(i/mid);
            if(count<=threshold)
                right=mid-1;
            else left=mid+1;
        }
        return left;
    }
}