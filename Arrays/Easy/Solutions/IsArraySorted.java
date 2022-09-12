// GFG
class Solution {
    boolean arraySortedOrNot(int[] arr, int n) {
        // code here
        for(int i=0;i<n-1;i++)
            if(arr[i]>arr[i+1]) return false;
        return true;
    }
}

// Leetcode (is Array sorted and Rotated)
class Solution {
    public boolean check(int[] nums) {
        int count=0, n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]>nums[(i+1)%n])
                count++;
            if(count>1)
                return false;
        }
        return true;
    }
}