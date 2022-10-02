class Solution {
    public long subArrayRanges(int[] nums) {
        long res=0;
        int n=nums.length;
        long nle[]=new long[n]; // # ele lesser than x in right side
        long nge[]=new long[n]; // # ele greater than x in right side
        long ple[]=new long[n]; // # ele lesser than x in left side
        long pge[]=new long[n]; // # ele greater than x in left side
        Stack<Integer> stack=new Stack<>();
        
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && nums[stack.peek()]>nums[i])
                stack.pop();
            ple[i]=stack.isEmpty()?i+1:i-stack.peek();
            stack.push(i);
        }
        
        stack.clear();
        
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && nums[stack.peek()]<nums[i])
                stack.pop();
            pge[i]=stack.isEmpty()?i+1:i-stack.peek();
            stack.push(i);
        }
        
        stack.clear();
        
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()]>=nums[i])
                stack.pop();
            nle[i]=stack.isEmpty()?n-i:stack.peek()-i;
            stack.push(i);
        }
        
        stack.clear();
        
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()]<=nums[i])
                stack.pop();
            nge[i]=stack.isEmpty()?n-i:stack.peek()-i;
            stack.push(i);
        }
        
        for(int i=0;i<n;i++){
            long lSubarray=nle[i]*ple[i], gSubarray=nge[i]*pge[i];
            res=res+ ((gSubarray-lSubarray)* nums[i]);
        }
        
        return res;
    }
}