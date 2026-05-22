class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res=new ArrayList<>();
        dfs(nums,0);
        return res;
    }
    public void dfs(int[] nums,int idx){
        if(idx==nums.length){
            List<Integer> cur=new ArrayList<>();
            for(int num:nums){
                cur.add(num);
            }
            res.add(cur);
            return;
        }
        for(int i=idx;i<nums.length;i++){
            swap(nums,i,idx);
            dfs(nums,idx+1);
            swap(nums,i,idx);
        }
    }
    public void swap(int[]nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
