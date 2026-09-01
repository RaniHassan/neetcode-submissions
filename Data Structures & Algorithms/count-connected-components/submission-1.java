class Solution {
    public int countComponents(int n, int[][] edges) {
        boolean[]visited=new boolean[n];
        int count= 0;
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[]edge:edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        for(int i=0;i<n;i++){
            if(visited[i]){
                continue;
            }
            count++;
            dfs(i,graph,visited);
        }
        return count;
    }
    public void dfs(int node,List<List<Integer>> graph,boolean[]visited){
        visited[node]=true;
        for(int neigbor:graph.get(node)){
            if(visited[neigbor]){
            continue;
            }
            dfs(neigbor,graph,visited);
        }
    }
}
