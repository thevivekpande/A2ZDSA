class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> counts=new HashMap<>();
        int i=0, j=0, n=fruits.length;
        for(;j<n;j++){
            counts.put(fruits[j], counts.getOrDefault(fruits[j], 0)+1);
            if(counts.size()>2){
                counts.put(fruits[i], counts.get(fruits[i])-1);
                // if(counts.get(fruits[i++])==0)
                // counts.remove(fruits[i-1]);
                counts.remove(fruits[i++], 0);
            }
        }
        return j-i;
    }
}