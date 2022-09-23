class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        Stack<Integer> stack=new Stack<>();
        for(int i=(n*2)-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=nums[i%n])
                stack.pop();
            res[i%n]=stack.isEmpty()?-1:stack.peek();
            stack.push(nums[i%n]);
        }
        return res;
    }
}