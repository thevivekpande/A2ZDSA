// Recursive Approach
class Solution
{
    int sign=1;
    int atoi(String s) {
        sign=1;
        return helper(s, 0, 0);
    }
    int helper(String s, int ind, int num){
        if(ind==s.length()) return num*sign;
        if(ind==0 && s.charAt(ind)=='-'){
            sign=-1;
            return helper(s, ind+1, num);
        }
        if(!Character.isDigit(s.charAt(ind))) return -1;
        num=num*10+(s.charAt(ind)-'0');
        return helper(s, ind+1, num);
    }
}
