class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        int[]indegree=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int[]pre:prerequisites){
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int[]result=new int[numCourses];
        int index=0;
        while(!q.isEmpty()){
            int course=q.poll();
            result[index++]=course;
            for(int next:graph.get(course)){
                indegree[next]--;
                if(indegree[next]==0){
                    q.add(next);
                }
            }
        }
        return index==numCourses?result:new int[0];
    }
}
