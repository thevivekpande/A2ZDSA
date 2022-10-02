// Leetcode
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map=new HashMap();
        PriorityQueue<Integer> pq=new PriorityQueue<>((a, b)->map.get(b)-map.get(a));
        for(int i : nums)
            map.put(i, map.getOrDefault(i, 0)+1);
        pq.addAll(map.keySet());
        int[] res=new int[k];
        int c=0;
        while(!pq.isEmpty() && c<k){
            res[c++]=pq.poll();
        }
        return res;
    }
}

// GFG
class Solution {
    public int[] topK(int[] nums, int k) {
        // Code here
        HashMap<Integer, Integer> map=new HashMap<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>((a, b)->map.get(a)==map.get(b)?a-b:map.get(a)-map.get(b));
        
        for(int i:nums)
            map.put(i, map.getOrDefault(i, 0)+1);
            
        for(int i : map.keySet()){
            pq.offer(i);
            if(pq.size()>k)
                pq.poll();
        }
        
        int[] res=new int[k];
        while(!pq.isEmpty() && k>0)
            res[--k]=pq.poll();
        
        return res;
    }
}