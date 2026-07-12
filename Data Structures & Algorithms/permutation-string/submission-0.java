class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        } else {
            int[] counts1 = new int[26];
            int[] counts2 = new int[26]; // For lowercase a-z
            
            for(int i = 0; i < s1.length(); i++) {
                counts1[s1.charAt(i) - 'a']++;
                counts2[s2.charAt(i) - 'a']++;
            }
            if (Arrays.equals(counts1, counts2)) {
                return true;
            }

            int left = 0;
            for (int right = s1.length(); right < s2.length(); right++) {
                counts2[s2.charAt(right) - 'a']++;
                counts2[s2.charAt(left) - 'a']--;
                left++;
                if(Arrays.equals(counts1, counts2)) {
                    return true;
                }
            }
            return false;
       
        }
        
    }
}
