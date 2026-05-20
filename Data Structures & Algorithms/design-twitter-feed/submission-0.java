class Twitter {
    Map<Integer,Twitt> twittMap;
    Map<Integer,Set<Integer>> followMap;
    int time;

    public Twitter() {
        twittMap=new HashMap<>();
        followMap=new HashMap<>();
        time=0;
        
    }
    
    public void postTweet(int userId, int tweetId) {
        time++;
        Twitt twitt=new Twitt(tweetId,userId,time);
        twitt.next=twittMap.get(userId);
        twittMap.put(userId,twitt);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer>res=new ArrayList<>();
        PriorityQueue<Twitt> heap=new PriorityQueue<>((a,b)->b.time-a.time);
        followMap.computeIfAbsent(userId,k->new HashSet<>()).add(userId);
        for(int follow:followMap.get(userId)){
            if(twittMap.containsKey(follow)){
                heap.offer(twittMap.get(follow));
            }
        }
        while(!heap.isEmpty()&&res.size()<10){
            Twitt t=heap.poll();
            res.add(t.id);
            if(t.next!=null){
                heap.offer(t.next);
            }
        }
        return res;

        
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId,k->new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId) && followerId != followeeId){
            followMap.get(followerId).remove(followeeId);
        }
    }

    class Twitt{
        private int id;
        private int u_id;
        private Twitt next;
        int time;
        public Twitt(int id ,int u_id,int time){
            this.time=time;
            this.id=id;
            this.u_id=u_id;
        }
    }
}
