class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap= new PriorityQueue<>(Comparator.comparingLong((int[] p)->((long)p[0]*p[0]+(long)p[1]*p[1])).reversed());
        for(int[] p:points){
            maxHeap.offer(p);
            if(maxHeap.size()>k){
                maxHeap.poll();
            }

        }
        int [][] res= new int[k][2];
        int i=0;
       while(!maxHeap.isEmpty()){
        res[i++]=maxHeap.poll();
       }
       return res;
    }
}
