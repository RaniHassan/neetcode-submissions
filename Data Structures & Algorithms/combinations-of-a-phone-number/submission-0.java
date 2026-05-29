class Solution {
    Map<Character,String> map;
    List<String> res;
    public List<String> letterCombinations(String digits) {
        res=new ArrayList<>();
        map=new HashMap<>();
        if(digits.length()==0){
        return res;}
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        dfs(digits,0,new StringBuilder());
        return res;
    }
    public void dfs(String digits,int index, StringBuilder s){
        if(index==digits.length()){
            res.add(s.toString());
            return;
        }
        String letters=map.get(digits.charAt(index));
        for(char letter:letters.toCharArray()){
            s.append(letter);
            dfs(digits,index+1,s);
            s.deleteCharAt(s.length()-1);
        }

    }
}
