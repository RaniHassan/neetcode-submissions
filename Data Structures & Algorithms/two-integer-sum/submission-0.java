class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> diffHash =new HashMap<>();
        for(int i=0;i<nums.length;i++){
           int diff=target-nums[i];
           if(diffHash.containsKey(diff)){
            return new int[]{diffHash.get(diff),i};
           }
           diffHash.put(nums[i],i);
        }
        return new int[]{};
    }
}
