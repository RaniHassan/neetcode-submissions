class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pair=new int[position.length][2];
        for(int i=0;i<position.length;i++){
            pair[i][0]=position[i];
            pair[i][1]=speed[i];
        }
        int fleet=1;
        Arrays.sort(pair,(a,b)->b[0]-a[0]);
        double prevTime=(double)(target-pair[0][0])/pair[0][1];
        for(int[] p:pair){
            double curTime=(double)(target-p[0])/p[1];
            if(curTime>prevTime){
                fleet++;
                prevTime=curTime;
            }
        }
        return fleet;
    }
}
