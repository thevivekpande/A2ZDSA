class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=0, right=0;
        for(int i:piles)
            right=Math.max(i, right);
        while(left<=right){
            int mid=left+((right-left)>>1);
            int hours=0;
            for(double i : piles)
                hours+=Math.ceil(i/mid);
            if(hours<=h)
                right=mid-1;
            else
                left=mid+1;
        }
        return left;
    }
}