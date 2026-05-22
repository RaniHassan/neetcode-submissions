class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        int end=0;
        int start=0;
        res.add(new ArrayList<>());
        for(int i=0;i<nums.length;i++){
            start=0;
            if(i>0&&nums[i]==nums[i-1]){
                start=end+1;
            }
            end=res.size()-1;
            int size=res.size();
            for(int j=start;j<size;j++){
                List<Integer> sub=new ArrayList<>(res.get(j));
                sub.add(nums[i]);
                res.add(sub);
            }
        }
        return res;
    }
}
