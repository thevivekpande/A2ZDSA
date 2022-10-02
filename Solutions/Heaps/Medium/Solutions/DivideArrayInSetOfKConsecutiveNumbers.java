class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        Map<Integer, Integer> map=new TreeMap<>();
        for(int i : nums) map.put(i, map.getOrDefault(i, 0)+1);
        for(int i : map.keySet()){
            if(map.get(i)>0){
                for(int it=k-1;it>=0;it--){
                    if(map.getOrDefault(it+i, 0)<map.get(i)) return false;
                    map.put(it+i, map.get(it+i)-map.get(i));
                }
            }
        }
        return true;
    }
}