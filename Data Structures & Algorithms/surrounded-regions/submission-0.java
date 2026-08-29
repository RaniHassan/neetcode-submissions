class Solution {
    public void solve(char[][] board) {
        int row=board.length;
        int col=board[0].length;
        for(int r=0;r<row;r++){
            if(board[r][0]=='O'){
                dfs(board,r,0);
            }
            if(board[r][col-1]=='O'){
                dfs(board,r,col-1);
            }
        }
        for(int c=0;c<col;c++){
            if(board[0][c]=='O'){
                dfs(board,0,c);
            }
            if(board[row-1][c]=='O'){
                dfs(board,row-1,c);
            }
        }
        for(int r=0;r<row;r++){
            for(int c=0;c<col;c++){
                if(board[r][c]=='O'){
                    board[r][c]='X';
                }
                if(board[r][c]=='S'){
                    board[r][c]='O';
                }
            }
        }

    }
    public void dfs(char[][] board,int r,int c){
        if(r<0||r>=board.length||c<0||c>=board[0].length||board[r][c]!='O'){ return;}
        board[r][c]='S';
        dfs(board,r,c+1);
        dfs(board,r,c-1);
        dfs(board,r+1,c);
        dfs(board,r-1,c);
    }
}
