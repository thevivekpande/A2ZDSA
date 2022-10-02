// Solution 01
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum=0, cur=0, n=cardPoints.length, min=Integer.MAX_VALUE;
        int j=0;
        k=n-k;
        for(int i=0;i<n;i++){
            sum+=cardPoints[i];
            cur+=cardPoints[i];
            if(i+1==k+j){
                min=Math.min(cur, min);
                cur-=cardPoints[j++];
            }
        }
        return k==0?sum:sum-min;
    }
}

// Solution 02
class Solution {
    public int maxScore(int[] card, int k) {
        int res=0, sum=0;
        int n=card.length;
        for(int i=0;i<k;i++)
            sum+=card[i];
        res=sum;
        for(int i=k-1;i>=0;i--){
            sum-=card[i];
            sum+=card[n-k+i];
            res=Math.max(res, sum);
        }
        return res;
    }
}