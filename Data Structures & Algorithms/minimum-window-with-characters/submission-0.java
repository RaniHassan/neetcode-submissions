class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()||t.isEmpty()) return"";
        Map<Character,Integer> countT=new HashMap<>();
        Map<Character,Integer> countS=new HashMap<>();
        for(char c:t.toCharArray()){
            countT.put(c,countT.getOrDefault(c,0)+1);
        }
        int reslen=Integer.MAX_VALUE;
        int[]res={-1,-1};
        int need=countT.size(),have=0,l=0;
        for(int i=0;i<s.length();i++)
        {
            countS.put(s.charAt(i),countS.getOrDefault(s.charAt(i),0)+1);
            if(countT.containsKey(s.charAt(i))&&countT.get(s.charAt(i)).equals(countS.get(s.charAt(i)))){
                have++;
            }
            while(have==need){
                if((i-l+1)<reslen){
                    reslen=i-l+1;
                res[0]=l;
                res[1]=i;
                }
                countS.put(s.charAt(l),countS.get(s.charAt(l))-1);
                if(countT.containsKey(s.charAt(l))&&countT.get(s.charAt(l))>countS.get(s.charAt(l))){
                    have--;
                }
                l++;
            }

        }
        return reslen== Integer.MAX_VALUE? "":s.substring(res[0],res[1]+1);

    }
}
