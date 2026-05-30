class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int [] res=new int[nums.length];
        int suffix=1;
        res[0]=1;
        for(int i=1;i<n;i++){
            res[i]=res[i-1]*nums[i-1];
        }
        for(int i=n-1;i>=0;i--){
            res[i] *=suffix;
            suffix *=nums[i];
        }
        return res;
    }
}  
