class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res=new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(sb,0,0,n);
        return res;
    }
    public void dfs(StringBuilder sb,int open,int close,int n){
        if(sb.length()==2*n){
            res.add(sb.toString());
        }
        if(open<n){
            sb.append('(');
            dfs(sb,open+1,close,n);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close<open){
            sb.append(')');
            dfs(sb,open,close+1,n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
