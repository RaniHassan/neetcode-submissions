class Solution {
    public boolean exist(char[][] board, String word) {
        int row=board.length;
        int col=board[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++)
               if(dfs(board,i,j,0,word))return true;
        }
        return false;
    }
    public boolean dfs(char[][] board,int row, int col,int i, String word){
        if(i==word.length())return true;
        if(row<0||col<0||row>=board.length||col>=board[0].length)return false;
        if(board[row][col]!=word.charAt(i))return false;
        char temp =board[row][col];
        board[row][col]='#';
        boolean found=dfs(board,row+1,col,i+1,word)||dfs(board,row,col+1,i+1,word)||dfs(board,row-1,col,i+1,word)||dfs(board,row,col-1,i+1,word);
        board[row][col]=temp;
        return found;
    }
}
