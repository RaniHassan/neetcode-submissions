class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer>map=new HashMap<>();
        int res=0;
        int l=0;
        for(int r=0;r<s.length();r++){
            if(map.containsKey(s.charAt(r))){
                l=Math.max(map.get(s.charAt(r))+1,l);
            }
            
                res=Math.max(res,r-l+1);
                map.put(s.charAt(r),r);
            
        }
        return res;
    }
}
