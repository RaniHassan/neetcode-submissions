class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        for(int t:tasks){
            freq[t-'A']++;
        }
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<26;i++){
            if(freq[i]>0){
            maxHeap.offer(freq[i]);
            }
        }
        int time=0;
        while(!maxHeap.isEmpty()){
            List<Integer> temp=new ArrayList<>();
            int cycle=n+1;
            while(cycle>0&&!maxHeap.isEmpty()){
                int cur=maxHeap.poll();
                if(cur>1){
                    temp.add(cur-1);
                }
                cycle--;
                time++;
            }
            for(int t:temp){
                maxHeap.offer(t);
            }
            if(maxHeap.isEmpty()){
                break;
            }
            time+=cycle;
        }
        return time;
    }
}
