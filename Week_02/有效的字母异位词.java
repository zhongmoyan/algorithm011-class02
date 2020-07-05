class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
       int[] counts=new int[26];//Ð¡Ð´×ÖÄ¸26
        for(int i=0;i<s.length();i++){
            counts[s.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length();i++){
            counts[t.charAt(i)-'a']--;
            if (counts[t.charAt(i)-'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}