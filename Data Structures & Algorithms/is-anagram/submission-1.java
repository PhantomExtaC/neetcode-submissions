class Solution {
    public boolean isAnagram(String s, String t) {
        //taking the standard approach, we start filling the 
        //string, one character at a time into the array,
        //the array will keep track of the characters 
        
        // alternative, sum all the ascii, if sum is different, eliminate the thing, if same, go for next comparision
        // but one issue, same values for two different ascii 

        // final approach, dictionary 

        if(s.length() != t.length()) {
            return false;
            //duh
        }
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int num : count) {
            if(num != 0) {
                return false;
            }
        }
         return true;
    }
}
