class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l=0,ROW=matrix.length,COL=matrix[0].length;
        int r=ROW*COL-1;
        while(l<=r){
            int m=l+(r-l)/2;
            if(target>matrix[m/COL][m%COL]){
                l=m+1;
            }
            else if(target<matrix[m/COL][m%COL]){
                r=m-1;
            }
            else return true;
        }
        return false;
        
    }
}
