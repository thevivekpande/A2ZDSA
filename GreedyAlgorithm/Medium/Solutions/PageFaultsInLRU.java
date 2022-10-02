class Solution{
    static int pageFaults(int N, int C, int pages[]){
        // code here
        Deque<Integer> q=new ArrayDeque<>();
        int fault=0, i=0;
        
        // fill dq untill size is equal to capacity
        // if dq contains cur page then put it on top
        // else put cur page on top
        // while putting new pages increase faults.
        while(i<N){
            if(q.contains(pages[i])){
                q.remove(pages[i]);
                q.offer(pages[i++]);
            }else{
                if(q.size()<C){
                    q.offer(pages[i++]);
                    fault++;
                }else break;
            }
        }
        
        // if dq contains page then put it on top
        // else as dq is full remove least frequent page and add cur page
        // while increasing cur pages increase faults.
        for(;i<N;i++){
            if(q.contains(pages[i])){
                q.remove(pages[i]);
                q.offer(pages[i]);
            }else{
                q.pollFirst();
                q.offer(pages[i]);
                fault++;
            }
        }
        
        return fault;
    }
}