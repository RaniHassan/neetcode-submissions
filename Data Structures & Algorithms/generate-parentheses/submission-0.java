class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res=new ArrayList<>();
        dfs("",0,0,n);
        return res;
    }
    public void dfs(String cur,int open,int close,int n){
        if(cur.length()==2*n){
            res.add(cur);
        }
        if(open<n){
            dfs(cur+'(',open+1,close,n);
        }
        if(close<open){
            dfs(cur+')',open,close+1,n);
        }
    }
}
