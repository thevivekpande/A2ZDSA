// using Dijkstra's (TLE)
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dest, int k) {
        Map<Integer, List<int[]>> map=new HashMap<>();
        for(int[] flight : flights){
            map.putIfAbsent(flight[0], new ArrayList<>());
            map.get(flight[0]).add(new int[]{flight[2], flight[1]});
        }
        
        PriorityQueue<int[]> heap=new PriorityQueue<>((a, b)->a[0]-b[0]);
        
        int res=0;
        heap.offer(new int[]{0, src, k+1});
        
        while(!heap.isEmpty()){
            int[] cur=heap.poll();
            int cost=cur[0];
            int city=cur[1];
            int stop=cur[2];
            if(city==dest) return cost;
            if(stop>0 && map.containsKey(city)){
                for(int[] next:map.get(city)){
                    heap.offer(new int[]{cost+next[0], next[1], stop-1});
                }
            }
        }
        
        return -1;
    }
}

// Using BellMan Ford
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] cost=new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[src]=0;
        for(int i=0;i<=K;i++)
        {
            int[] temp= Arrays.copyOf(cost,n);
            for(int[] f: flights)
            {
                int curr=f[0],next=f[1],price=f[2];
                if(cost[curr]==Integer.MAX_VALUE)
                    continue;
                temp[next]=Math.min(temp[next],cost[curr]+price);
            }
            cost=temp;
        }
        return cost[dst]==Integer.MAX_VALUE?-1:cost[dst];
    }
}