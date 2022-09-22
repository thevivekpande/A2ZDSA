// Leetcode
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList();
        int n=nums.length;
        for(int i=1;i<=(1<<n);i++){
            List<Integer> temp=new ArrayList();
            for(int j=0;j<n;j++)
                if((i&(1<<j))!=0) temp.add(nums[j]);
            res.add(temp);
        }
        return res;
    }
}

// GFG
class Solution
{
    public List<String> AllPossibleStrings(String s)
    {
        // Code here
        int n=s.length();
        List<String> ans=new ArrayList<>();
        for(int i=1;i< 1<<n;i++){
            String str="";
            for(int j=0;j<n;j++){
                if((i&(1<<j))>0) str+=s.charAt(j);
            }
            ans.add(str);
        }
        Collections.sort(ans);
        return ans;
    }
}
/*
0 0 0 
0 0 1 c
0 1 0 b
0 1 1 bc
1 0 0 a
1 0 1 ac
1 1 0 ab
1 1 1 abc
*/