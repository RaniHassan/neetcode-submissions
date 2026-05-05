class Solution {
    public boolean isPalindrome(String s) {
        int f=0 ,l=s.length()-1;
        while(f<l){
            while(f<l&&!Character.isLetterOrDigit(s.charAt(f))){
                f++;
            }
            while(f<l&&!Character.isLetterOrDigit(s.charAt(l))){
                l--;
            }
            if(Character.toLowerCase(s.charAt(f))!=Character.toLowerCase(s.charAt(l)))
            {
                return false;
            }
            f++;
            l--;
        }
        return true;
    }
}
