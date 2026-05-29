class Solution {
    boolean[][] dp;
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res=new ArrayList<>();
        int n=s.length();
        dp=new boolean[n][n];
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(s.charAt(i)==s.charAt(j)&&(j-i<=2||dp[i+1][j-1])){
                    dp[i][j]=true;
                }
            }
        }
        dfs(s,0,new ArrayList<>());
        return res;
        
    }
    public void dfs(String s,int start,List<String> path){
        if(start==s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int end=start;end<s.length();end++){
            if(!dp[start][end]){
                continue;
            }
            path.add(s.substring(start,end+1));
            dfs(s,end+1,path);
            path.remove(path.size()-1);
        }
    }
}
