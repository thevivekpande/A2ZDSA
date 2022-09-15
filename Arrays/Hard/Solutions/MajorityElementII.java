class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res=new ArrayList();
        int num1=nums[0], num2=nums[0], cnt1=0, cnt2=0;
        
        for(int i:nums){
            if(num1==i)
                cnt1++;
            else if(num2==i)
                cnt2++;
            else if(cnt1==0){
                cnt1++;
                num1=i;
            }else if(cnt2==0){
                cnt2++;
                num2=i;
            }else{
                cnt1--;
                cnt2--;
            }
        }
        
        int n=(nums.length)/3;
        cnt1=0;
        cnt2=0;
        for(int i:nums){
            if(num1==i) cnt1++;
            else if(num2==i) cnt2++;
        }
        
        if(cnt1>n) res.add(num1);
        if(cnt2>n) res.add(num2);
        
        return res;
    }
}