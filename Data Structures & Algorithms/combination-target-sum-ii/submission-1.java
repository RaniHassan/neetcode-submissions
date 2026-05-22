class Solution {
    List<List<Integer>> res=new ArrayList<>();
    Map<Integer,Integer> count=new HashMap<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> unique =new ArrayList<>();
        for(int num:candidates){
            if(!count.containsKey(num)){
                unique.add(num);
            }
            count.put(num,count.getOrDefault(num,0)+1);
        }
        dfs(unique,target,0,new ArrayList<>());
        return res;
    }
    public void dfs(List<Integer> unique,int target,int i,List<Integer> cur){
        if(target==0){
            res.add(new ArrayList<>(cur));
            return;
        }
        if(target<0||i>=unique.size()){
            return;
        }
        if(count.get(unique.get(i))>0){
            cur.add(unique.get(i));
            count.put(unique.get(i),count.get(unique.get(i))-1);
            dfs(unique,target-unique.get(i),i,cur);
            count.put(unique.get(i),count.get(unique.get(i))+1);
            cur.remove(cur.size()-1);
        }
        dfs(unique,target,i+1,cur);
        
    }
}
