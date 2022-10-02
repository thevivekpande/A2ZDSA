class Solution
{
     long floorSqrt(long x)
	 {
		// Your code here
		long left=0, right=x;
		while(left<=right){
		    long mid=left+((right-left)>>1);
		    long prod=mid*mid;
		    if(prod==x) return mid;
		    else if(prod<x) left=mid+1;
		    else right=mid-1;
		}
		return right;
	 }
}
