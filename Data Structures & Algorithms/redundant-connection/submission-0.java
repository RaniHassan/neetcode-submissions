class Solution {
    private  int[]parents;
    public int[] findRedundantConnection(int[][] edges) {
        int n =edges.length;
        parents=new int[n+1];
        for(int i=1;i<=n;i++){
            parents[i]=i;
        }
        int[] ans=new int[0];
        for(int[]edge:edges){
            int a=edge[0];
            int b=edge[1];
            if(find(a)==find(b)){
                ans=edge;
            }
            else{
                union(a,b);
            }
        }
        return ans;

    }
    public int find(int node){
        if(parents[node]!=node){
            parents[node]=find(parents[node]);
        }
        return parents[node];
    }
    public void union(int a,int b){
        int rootA=find(a);
        int rootB=find(b);
        parents[rootA]=rootB;
    }
}
