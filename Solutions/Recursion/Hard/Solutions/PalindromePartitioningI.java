class Solution {
    private void helper(int ind, String s, List<List<String>> res, List<String> ds){
        if(ind==s.length())
            res.add(new ArrayList(ds));
        
        for(int i=ind; i<s.length(); i++){
            if(isPalindrome(s, ind, i)){
                ds.add(s.substring(ind, i+1));
                helper(i+1, s, res, ds);
                ds.remove(ds.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int left, int right){
        while(left<right){
             if(s.charAt(left++)!=s.charAt(right--)) return false;
        }
        return true;
    }
    
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList();
        helper(0, s, res, new ArrayList());
        return res;
    }
}