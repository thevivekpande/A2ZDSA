class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count=new int[26];
        int max=0, maxCount=0;
        for(char ch : tasks){
            count[ch-'A']++;
            if(count[ch-'A']==max)
                maxCount++;
            else if(count[ch-'A']>max){
                max=count[ch-'A'];
                maxCount=1;
            }
        }
        return Math.max(tasks.length, (max-1)*(n+1)+maxCount);
    }
}

// using PriorityQeue
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