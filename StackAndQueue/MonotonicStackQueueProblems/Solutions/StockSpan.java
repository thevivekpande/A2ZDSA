// Leetcode
class StockSpanner {
    Stack<int[]> stack;

    public StockSpanner() {
        stack=new Stack<>();
    }
    
    public int next(int price) {
        int span=1;
        while(!stack.isEmpty() && stack.peek()[0]<=price)
            span+=stack.pop()[1];
        stack.push(new int[]{price, span});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

 // GFG
 class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n)
    {
        // Your code here
        Stack<int[]> stack=new Stack<>();
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            int span=1;
            while(!stack.isEmpty() && stack.peek()[0]<=price[i])
                span+=stack.pop()[1];
            stack.push(new int[]{price[i], span});
            res[i]=span;
        }
        return res;
    }
    
}