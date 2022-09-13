// Leetcode
class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int i=n-2;
        while(i>=0 && nums[i]>=nums[i+1])
            i--;
    
        if(i>=0){
            int j=n-1;
            while(j>i && nums[j]<=nums[i])
                j--;
            swap(nums, i, j);
        }
        reverse(nums, i+1);
    }
    
    private void swap(int[] nums ,int left, int right){
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }
    
    private void reverse(int[] nums, int left){
        int right=nums.length-1;
        while(left<right){
            swap(nums, left, right);
            right--;
            left++;
        }
    }
}

// GFG

class Solution{
    static List<Integer> nextPermutation(int N, int arr[]){
        // code here
        List<Integer> res=new ArrayList<>();
        int i=N-2;
        while(i>=0 && arr[i]>=arr[i+1])
            i--;
        if(i>=0){
            int j=N-1;
            while(j>i && arr[i]>=arr[j])
                j--;
            swap(arr , i, j);
        }
        
        reverse(arr, i+1);
        
        for(int a:arr)
            res.add(a);
            
        return res;
    }
    
    static void swap(int[] arr, int left, int right){
        int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
    }
    
    static void reverse(int[] arr, int left){
        int right=arr.length-1;
        while(left<right){
            swap(arr, left, right);
            left++;
            right--;
        }
    }
}