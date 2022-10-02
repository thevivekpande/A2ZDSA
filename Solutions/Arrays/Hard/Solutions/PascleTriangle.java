// Leetcode
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList();
        int num=1;
        for(int i=0;i<numRows;i++){
            List<Integer> list=new ArrayList();
            for(int j=0;j<i;j++){
                if(j==0) num=1;
                else num=num*(i-j+1)/j;
                list.add(num);
            }
            list.add(1);
            res.add(list);
        }
        return res;
    }
}

// GFG
class Solution {
    ArrayList<Long> nthRowOfPascalTriangle(int n) {
        // code here
        ArrayList<Long> res=new ArrayList<>();
        for(int i=0;i<n;i++)
            res.add(0l);
        int mod=(int)1e9 + 7;
        res.set(0,1l);
        for(int i=0;i<n;i++){
            for(int j=i;j>=1;j--){
                res.set(j, (res.get(j)%mod + res.get(j-1)%mod)%mod);
            }
        }
        return res;
    }
}