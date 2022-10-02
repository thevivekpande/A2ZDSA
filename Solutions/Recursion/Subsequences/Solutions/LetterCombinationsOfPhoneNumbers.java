// Leetcode
class Solution {
    private void helper(int ind, String digits, String[] values, List<String> res, StringBuilder ds){
        if(ind==digits.length()){
            res.add(ds.toString());
            return;
        }
        
        char[] charArr=values[digits.charAt(ind)-'0'].toCharArray();
        for(int i=0;i<charArr.length;i++){
            ds.append(charArr[i]);
            helper(ind+1, digits, values, res, ds);
            ds.deleteCharAt(ds.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        String[] values=new String[]{"", "", "abc","def", "ghi", "jkl","mno", "pqrs", "tuv","wxyz"};
        List<String> res=new ArrayList();
        if(digits.length()==0) return res;
        helper(0, digits, values, res, new StringBuilder());
        return res;
    }
}


// GFG
class Solution
{
    private static void helper(int ind, int[] digits, String[] values, ArrayList<String> res, StringBuilder ds){
        if(ind==digits.length){
            res.add(ds.toString());
            return;
        }
        
        char[] charArr=values[digits[ind]].toCharArray();
        for(int i=0;i<charArr.length;i++){
            ds.append(charArr[i]);
            helper(ind+1, digits, values, res, ds);
            ds.deleteCharAt(ds.length()-1);
        }
    }

    //Function to find list of all words possible by pressing given numbers.
    static ArrayList <String> possibleWords(int a[], int N)
    {
        // your code here  
        String[] values=new String[]{"", "", "abc","def", "ghi", "jkl","mno", "pqrs", "tuv","wxyz"};
        ArrayList<String> res=new ArrayList<>();
        if(a.length==0) return res;
        helper(0, a, values, res, new StringBuilder());
        return res;

    }
}
