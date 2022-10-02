class Solution {
    int print2largest(int arr[], int n) {
        // code here
        int largest=-1;
        int secondLargest=-1;
        for(int i:arr){
            if(i>largest){
                secondLargest=largest;
                largest=i;
            }else if(i>secondLargest && i!=largest){
                secondLargest=i;
            }
        }
        return secondLargest;
    }
}