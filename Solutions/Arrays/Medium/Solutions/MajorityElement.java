// Leetcode
class Solution {
    public int majorityElement(int[] nums) {
        int count=0, num=nums[0];
        for(int i:nums){
            if(count==0)
                num=i;
            if(num==i) count++;
            else count--;
        }
        return num;
    }
}

//GFG
class Solution
{
    static int majorityElement(int a[], int size)
    {
        // your code here
        int count=0, num=a[0];
        for(int i:a){
            if(count==0)
                num=i;
            if(num==i) count++;
            else count--;
        }
        count=0;
        for(int i:a)
            if(num==i) count++;
        return count>(size/2)?num:-1;
    }
}