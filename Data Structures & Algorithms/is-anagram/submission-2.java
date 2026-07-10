class Solution {
    public boolean isAnagram(String s, String t) {
        //for an anagram, we can assume using another hashmap but this time storing the frequencies of all instances
        if (s.length() != t.length()) {
            return false;
        }
        int[] charCounts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++;
            charCounts[t.charAt(i) - 'a']--;
        }

        for (int count : charCounts) {
            if (count != 0) {
                return false;
            }
        }
    return true;
    }
}
