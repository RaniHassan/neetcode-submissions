class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph =new ArrayList<>();
        boolean[]visited=new boolean[numCourses];
        boolean[]path=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] pre:prerequisites){
            graph.get(pre[1]).add(pre[0]);
        }
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(hasCycle(i,graph,visited,path))
                return false;
            }
        }
        return true;
    }
    public boolean hasCycle(int course,List<List<Integer>> graph,boolean[]visited,boolean[]path){
        visited[course]=true;
        path[course]=true;
        for(int nextcourse:graph.get(course)){
             if (path[nextcourse]) {
                return true;
            }
            if(!visited[nextcourse])
            {
                if(hasCycle(nextcourse,graph,visited,path))
                return true;
            }
        }
        path[course]=false;
        return false;
    }
}
