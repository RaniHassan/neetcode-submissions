class KthLargest {
    private int K;
    public PriorityQueue<Integer> q;
    public KthLargest(int k, int[] nums) {
        K=k;
        q=new PriorityQueue<>();
        for(int num:nums){
            q.offer(num);
            if(q.size()>K){
                q.poll();
            }
        }
        
    }
    
    public int add(int val) {
        q.offer(val);
            if(q.size()>K){
                q.poll();
                }
                return q.peek();
        
    }
}
