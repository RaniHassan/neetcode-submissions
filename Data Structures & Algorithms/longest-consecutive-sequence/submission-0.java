class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> exist=new HashSet<>();
        for(int num:nums){
            exist.add(num);
        }
        int length=0;
        for(int num:exist){
            if(!exist.contains(num-1)){
            int currentNum=num;
            int currentLength=1;

            while(exist.contains(currentNum+1)){
                currentLength++;
                currentNum++;
            }
            length=Math.max(length,currentLength);
            }
        }
        return length;
    }
}
