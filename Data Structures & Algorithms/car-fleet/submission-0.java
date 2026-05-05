class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int [][] pairs=new int[position.length][2];
        for(int i=0;i<position.length;i++){
            pairs[i][0]=position[i];
            pairs[i][1]=speed[i];
        }
        Arrays.sort(pairs,(a,b)->b[0]-a[0]);
        double prevTime=(double)(target-pairs[0][0])/pairs[0][1];
        int fleet=1;
        for(int i=1;i<position.length;i++){
            double currentTime=(double)(target-pairs[i][0])/pairs[i][1];
            if(currentTime>prevTime){
                fleet++;
                prevTime=currentTime;
            }
        }
        return fleet;
    }
}
