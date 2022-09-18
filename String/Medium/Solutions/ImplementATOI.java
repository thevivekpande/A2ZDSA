class Solution
{
    int atoi(String s) {
	// Your code here
        int n=s.length(), i=0;
        while(i<n && s.charAt(i)==' ') i++;
        long res=0;
        int sign=1;
        if(i==n) return -1;
        if((s.charAt(i)=='+' || s.charAt(i)=='-'))
            sign=s.charAt(i++)=='+'?1:-1;
        while(i<n){
            if(Character.isDigit(s.charAt(i))){
                int val=s.charAt(i++)-'0';
                res=res*10+val;
            }else return -1;
        }
        return (int)(sign*res);
    }
}
