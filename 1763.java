
#LongestNiceSubstring
class Solution {
    public String longestNiceSubstring(String s) {
     int n = s.length();
     String longestNice = "";
        
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String substring = s.substring(i, j);
                if (isNice(substring) && substring.length() > longestNice.length()) {
                    longestNice = substring;
                }
            }
        }
        
        return longestNice;
    }
    
    private boolean isNice(String substring) {
        boolean[] lowerCase = new boolean[26];
        boolean[] upperCase = new boolean[26];
        
        for (char c : substring.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lowerCase[c - 'a'] = true;
            } else {
                upperCase[c - 'A'] = true;
            }
        }
        
        for (int i = 0; i < 26; i++) {
            if (lowerCase[i] != upperCase[i]) {
                return false;
            }
        }
        
        return true;
    }
}
