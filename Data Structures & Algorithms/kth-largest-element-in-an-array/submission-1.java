class Solution {
    public int findKthLargest(int[] nums, int k) {
        int newK=nums.length-k;
        if(k>nums.length){
            return -1;
        }
       return quickSelect(nums,0,nums.length-1,newK);
        
    }
    public int quickSelect(int[]nums,int l,int r,int k){
        if(l==r)return nums[l];
        int pivot = partition(nums,l,r);
        if(pivot==k){return nums[pivot];}
        if(pivot<k) return quickSelect(nums,pivot+1,r,k);
        return quickSelect(nums,0,pivot-1,k);
    }
    public int partition(int[]nums,int l,int r){
        int pivot=nums[r];
        int i=l;
        for(int j=l;j<r;j++){
            if(nums[j]<=pivot){
                swap(nums,j,i);
                i++;
            }
        }
        swap(nums,i,r);
        return i;
    }
    public void swap(int []nums,int j,int i){
        int temp =nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
