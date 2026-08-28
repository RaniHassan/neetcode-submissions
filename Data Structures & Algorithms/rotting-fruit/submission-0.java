class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int row=grid.length,col=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        int time=0,fresh=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    fresh++;
                }
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
            }
        }
        while(fresh>0&&!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                int[] cur=q.poll();
                int r=cur[0];
                int c=cur[1];
                for(int[]dir:directions){
                    int gr=r+dir[0];
                    int gc=c+dir[1];
                    if(gr>=0&&gr<row&&gc>=0&&gc<col&&grid[gr][gc]==1){
                        fresh--;
                        grid[gr][gc]=2;
                        q.add(new int[]{gr,gc});
                    }
                }
            }
            time++;
        } 
        return fresh==0?time:-1;
    }
}
