class Solution {
    List<List<Integer>>res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res=new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> cur=new ArrayList<>();
        dfs(nums,0,cur,target,0);
        return res;
    }
    public void dfs(int[]nums,int i,List<Integer> cur,int target,int total){
        if(target==total){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int j=i;j<nums.length;j++){
        if(total+nums[j]>target){
            return;
        }
        cur.add(nums[j]);
        dfs(nums,j,cur,target,total+nums[j]);
        cur.remove(cur.size()-1);
        }
    }
}
