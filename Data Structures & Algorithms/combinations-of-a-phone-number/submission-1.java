class Solution {
    
    public List<String> letterCombinations(String digits) {
       List<String>  res=new ArrayList<>();
       Map<Character,String> map =new HashMap<>();
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
        res.add("");
        for(char digit:digits.toCharArray()){
            String letters=map.get(digit);
            List<String> next=new ArrayList<>();
            for(String cur:res){
                for(char letter:letters.toCharArray()){
                    next.add(cur+letter);
                }
            }
            res=next;
        }
        return res;
    }
    
        
}
