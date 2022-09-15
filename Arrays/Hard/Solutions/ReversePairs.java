class Solution {
    private int merge(int[] nums, int[] temp, int left, int mid, int right){
        int res=0;
        int i=left, j=mid+1;
        for(;i<=mid;i++){
            while(j<=right && nums[i]>(2*(long)nums[j]))
                j++;
            res+=j-mid-1;
        }
        
        i=left; j=mid+1;
        int k=left;
        while(i<=mid && j<=right){
            if(nums[i]<nums[j])
                temp[k++]=nums[i++];
            else temp[k++]=nums[j++];
        }
        while(i<=mid) temp[k++]=nums[i++];
        while(j<=right) temp[k++]=nums[j++];
        for(i=left;i<=right;i++)
            nums[i]=temp[i];
        return res;
    }
    private int mergeSort(int[] nums, int[] temp, int left, int right){
        int res=0;
        if(right>left){
            int mid=(left+right)/2;
            res+=mergeSort(nums, temp, left, mid);
            res+=mergeSort(nums, temp, mid+1, right);
            res+=merge(nums, temp, left, mid, right);
        }
        return res;
    }
    public int reversePairs(int[] nums) {
        int n=nums.length;
        int[] temp=new int[n];
        return mergeSort(nums, temp, 0, n-1);
    }
}