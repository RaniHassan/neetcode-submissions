class KthLargest {
    private int k;
    private PriorityQueue<Integer> q;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        this.q=new PriorityQueue<>();
        for(int num:nums){
            this.q.offer(num);
            if(this.q.size()>k){
                this.q.poll();
            }
        }
        
    }
    
    public int add(int val) {
        this.q.offer(val);
            if(this.q.size()>k){
                this.q.poll();
                }
                return this.q.peek();
        
    }
}
