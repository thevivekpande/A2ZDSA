class Twitter {
    private Map<Integer, Deque<Integer[]>> tweets;
    private Map<Integer, Set<Integer>> users;
    private int nextTweetId;

    public Twitter() {
        tweets=new HashMap<>();
        users=new HashMap<>();
        nextTweetId=1;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new LinkedList<>());
        tweets.get(userId).add(new Integer[] {tweetId, nextTweetId++});
        if(tweets.get(userId).size() > 10){
            tweets.get(userId).pollFirst();
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Integer[]> pq=new PriorityQueue<>((a, b) -> a[1]-b[1]);
        
        addTweetsByUserId(pq, userId);
        
        for(Integer followeeId : users.getOrDefault(userId, new HashSet<>())){
            addTweetsByUserId(pq, followeeId);
        }
        
        int size=pq.size();
        List<Integer> feed=new ArrayList<>();
        while(!pq.isEmpty())
            feed.add(pq.poll()[0]);
        
        Collections.reverse(feed);
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId!=followeeId){
            users.putIfAbsent(followerId, new HashSet<>());
            users.get(followerId).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(users.containsKey(followerId))
            users.get(followerId).remove(followeeId);
    }
    
    private void addTweetsByUserId(PriorityQueue<Integer[]> pq, int userId){
        LinkedList<Integer[]> tweetList = (LinkedList<Integer[]>)tweets.getOrDefault(userId, new LinkedList<>());
        for(Integer[] tweet : tweetList){
            pq.add(tweet);
            if(pq.size()>10)
                pq.poll();
        } 
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */