class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total =nums1.length+nums2.length;
        int mid=total/2;
        int i=0,j=0;
        int current=0,prev=0;
        for(int count=0;count<=mid;count++){
            prev=current;
            if(i<nums1.length&&(j>=nums2.length||nums1[i]<nums2[j])){
                current=nums1[i++];
            }
            else { current=nums2[j++];}
        }
        if(total%2==1){
            return current;
        }
        return (prev + current) / 2.0;
    }
}
