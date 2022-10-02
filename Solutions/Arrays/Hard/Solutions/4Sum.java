// GFG
class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        // code here
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        Arrays.sort(arr);
        int n=arr.length;
        
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-2;j++){
                int sum=k-(arr[i]+arr[j]);
                int low=j+1, high=n-1;
                
                int minTwoSum=arr[low]+arr[low+1];
                int maxTwoSum=arr[high]+arr[high-1];
                if(minTwoSum>sum || maxTwoSum<sum) continue;
                
                while(low<high){
                    if(arr[low]+arr[high]==sum){
                        ArrayList<Integer> temp=new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[low]);
                        temp.add(arr[high]);
                        if(!res.contains(temp))
                            res.add(temp);
                        low++; high--;
                    }else if(arr[low]+arr[high]<sum) low++;
                    else high--;
                }
            }
        }
        
        return res;
    }
}


// Leetcode
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
        List<List<Integer>> res=new ArrayList();
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-2;j++){
                long sum=(long)target-((long)nums[i]+(long)nums[j]);
                int low=j+1, high=n-1;
                
                int minTwoSum=nums[low]+nums[low+1];
                int maxTwoSum=nums[high]+nums[high-1];
                if(minTwoSum>sum || maxTwoSum<sum) continue;
                
                while(low<high){
                    if(nums[low]+nums[high]==sum){
                        if(!res.contains(Arrays.asList(nums[i], nums[j], nums[low], nums[high])))
                        res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        low++;
                        high--;
                    }else if(nums[low]+nums[high]<sum) low++;
                    else high--;
                }
                
            }
        }
        
        return res;
    }
}