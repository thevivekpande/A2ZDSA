class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod=(int)1e9 + 7;
        int n=arr.length;
        Stack<Integer> stack=new Stack();
        long[] ple=new long[n];
        long[] nle=new long[n];
        
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i])
                stack.pop();
            ple[i]=stack.isEmpty()?i+1:i-stack.peek();
            stack.push(i);
        }
        
        stack.clear();
        
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i])
                stack.pop();
            nle[i]=stack.isEmpty()?n-i:stack.peek()-i;
            stack.push(i);
        }
        
        long res=0;
        for(int i=0;i<n;i++){
            res=(res+(arr[i]*nle[i]*ple[i]))%mod;
        }
        
        return (int)res;
    }
}