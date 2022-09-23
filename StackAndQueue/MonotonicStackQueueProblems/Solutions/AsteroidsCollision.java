class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack=new Stack<>();
        for(int i:asteroids){
            boolean flag=false;
            while(!stack.isEmpty() && i<0 && stack.peek()>0){
                if(stack.peek()+i<0){
                    stack.pop();
                    continue;
                }else if(stack.peek()+i==0){
                    stack.pop();
                }
                flag=true;
                break;
            }
            if(!flag)
                stack.push(i);
        }
        int[] res=new int[stack.size()];
        for(int i=res.length-1;i>=0;i--)
            res[i]=stack.pop();
        return res;
    }
}