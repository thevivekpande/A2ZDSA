
/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class ItemComparator implements Comparator<Item>{
    @Override
    public int compare(Item i1, Item i2){
        double v1= ((double)i1.value/(double)i1.weight);
        double v2= ((double)i2.value/(double)i2.weight);
        if(v1<v2) return 1;
        else if(v2<v1) return -1;
        return 0;
    }
}

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        // Your code here
        Arrays.sort(arr, new ItemComparator());
        double res=0.00;
        int i=0;
        while(i<n && W>0){
            res+=((double)arr[i].value / (double)arr[i].weight)*(Math.min(W, arr[i].weight));
            W-=Math.min(W, arr[i++].weight);
        }
        return res;
    }
}