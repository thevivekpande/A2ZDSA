class Solution {
    static String armstrongNumber(int n){
        // code here
        int temp=n;
        int sum=0;
        while(temp>0){
            sum+=Math.pow(temp%10,3);
            temp/=10;
        }
        return sum==n?"Yes":"No";
    }
}