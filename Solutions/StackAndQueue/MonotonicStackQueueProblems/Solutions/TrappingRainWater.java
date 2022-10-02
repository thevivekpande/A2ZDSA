// using Two Pointer
class Solution{
    static long trappingWater(int height[], int n) { 
        // Your code here
        int left=0, right=n-1, lMax=0, rMax=0;
        long res=0;
        while(left<right){
            if(height[left]<=height[right]){
                if(height[left]>lMax) lMax=height[left];
                else res+=lMax-height[left];
                left++;
            }else{
                if(height[right]>rMax) rMax=height[right];
                else res+=rMax-height[right];
                right--;
            }
        }
        return res;
    } 
}

// Using Stack (Histogram Concept)
class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack=new Stack<>();
        int res=0;
        int i=0, n=height.length;
        while(i<n){
            if(stack.isEmpty() || height[stack.peek()]>=height[i])
                stack.push(i++);
            else{
                int pre=stack.pop();
                if(!stack.isEmpty()){
                    int minHeight=Math.min(height[i], height[stack.peek()]);
                    res+=(minHeight-height[pre])*(i-stack.peek()-1);
                }
            }
        }
        return res;
    }
}