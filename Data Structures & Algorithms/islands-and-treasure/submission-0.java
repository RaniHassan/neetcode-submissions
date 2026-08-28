class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int[][] directions={{1,0},{-1, 0},{0, 1}, {0, -1}};
        int INF=2147483647;
        Queue<int[]> q=new LinkedList<>();
        int row=grid.length,col=grid[0].length;
        for(int i=0;i<row;i++){
        for(int j=0;j<col;j++)
        {
            if(grid[i][j]==0){
                q.add(new int[]{i,j});
            }
        }}
        while(!q.isEmpty()){
            int[]cur=q.poll();
            int r=cur[0];
            int c=cur[1];
            for(int[]dir:directions){
                int gr=r+dir[0];
                int gc=c+dir[1];
                if(gr<0||gr>=row||gc<0||gc>=col) continue;
                if(grid[gr][gc]!=INF) continue;
                grid[gr][gc]=grid[r][c]+1;
                q.add(new int[]{gr,gc});
            }
        }
    }
}
