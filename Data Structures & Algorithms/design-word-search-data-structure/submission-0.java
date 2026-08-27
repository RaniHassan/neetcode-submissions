class TrieNode {
    Map<Character,TrieNode>children=new HashMap<>();
    boolean isWord=false;
}
class WordDictionary {
    private final TrieNode root;
    public WordDictionary() {
        root=new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur=root;
        for(char c:word.toCharArray()){
            cur.children.putIfAbsent(c,new TrieNode());
            cur=cur.children.get(c);
        }
        cur.isWord=true;
    }

    public boolean search(String word) {
        return dfs(root, word, 0);
    }
    public boolean dfs(TrieNode root,String word,int index){
        if(index==word.length()){
            return root.isWord;
        }
       char c= word.charAt(index);
        if(c!='.'){
            if(!root.children.containsKey(c)){
                return false;
            }
            TrieNode cur=root.children.get(c);
            return dfs(cur,word,index+1);
        }
        for(TrieNode node:root.children.values()){
            if(dfs(node,word,index+1)){return true;}
            
        }
        return false;
    }
}
