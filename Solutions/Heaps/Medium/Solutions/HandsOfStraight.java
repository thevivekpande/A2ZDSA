class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(n==0) return tasks.length;
        
        HashMap<Character, Integer> map=new HashMap<>();
        for(char task : tasks) map.put(task, map.getOrDefault(task, 0)+1);
        
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        pq.addAll(map.values());
        
        int max=pq.poll()-1;
        int idles = max*n;
        while(!pq.isEmpty()) idles-=Math.min(pq.poll(),max);
        
        return tasks.length +  Math.max(0, idles);
    }
}