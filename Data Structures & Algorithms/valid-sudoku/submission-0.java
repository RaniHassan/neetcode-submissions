class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen=new HashSet<>();
        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){
                if(board[row][col]=='.'){
                    continue;
                }
                int val=board[row][col];
                String rowKey=val+"in row"+row;
                String colKey=val+"in col"+col;
                String boxKey=val+"in box"+row/3+"-"+col/3;
                if(!seen.add(rowKey)||!seen.add(colKey)||!seen.add(boxKey))return false;
            }
        }
        return true;
    }
}
