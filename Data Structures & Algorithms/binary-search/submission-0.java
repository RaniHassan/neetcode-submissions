class Solution {
    public int search(int[] nums, int target) {
        int l=0,r=nums.length-1;
       return binarySerach( l, r, nums, target);

    }
    public int binarySerach(int l,int r, int[]nums,int target){
        if(l>r)return -1;
        int m=l+(r-l)/2;
        if(nums[m]==target) return m;
        return nums[m]<target?binarySerach( m+1, r, nums, target):binarySerach( l, m-1, nums, target);

    }
}
