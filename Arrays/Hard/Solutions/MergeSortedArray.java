// Leetcode
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l1=m-1, l2=n-1, f1=m+n-1;
        while(l1>=0 && l2>=0){
            nums1[f1--]=nums1[l1]>nums2[l2]?nums1[l1--]:nums2[l2--];
        }
        
        while(l2>=0) nums1[f1--]=nums2[l2--];
    }
}

//GFG
class Solution
{
    //Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int n, int m) 
    {
        // code here 
        int i=0, j=0, k=n-1;
        while(i<=k && j<m){
            if(arr1[i]<arr2[j]){
                i++;
            }
            else {
                long temp=arr2[j];
                arr2[j]=arr1[k];
                arr1[k]=temp;
                j++;
                k--;
            }
        }
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}
