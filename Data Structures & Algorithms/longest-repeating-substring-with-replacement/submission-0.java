class Solution {
    public int characterReplacement(String s, int k) {
      /*
      We are given a string of only uppercase characters
      no blanks no special characters
      goal = find Max such that if k replacements are to be made
      then you will have the longest substring of the same element
      
      to approach this problem we assume the cases 
      1. All the same letters 
      if all are the same, then the hashset should have only one entry,
      then we can return s.length()
      if entries in hashset <= k, return s.length()
      else 
      this is where I am stuck
       if alternative then we can assume 
      create hashset, then begin extending the window
      store the current longest length 
      if the hashset has a new element and entries < k, keep extending till it reaches k
      keep updating the longest length
      if different entries extend k, remove the left most element till it reaches less than k
      then extend the right till it reaches the end, while keeping an eye on the no. of entries
      */ 
        int[] charCounts = new int[26];
        int left = 0;
        int maxLength = 0;
        int maxFrequency = 0;

        for (int right = 0; right < s.length(); right++) {
            charCounts[s.charAt(right) - 'A']++;

            maxFrequency = Math.max(maxFrequency, charCounts[s.charAt(right) - 'A']);

            int windowSize = right - left + 1;
            if(windowSize - maxFrequency > k) {
                charCounts[s.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left +1);
        }
        return maxLength;

    }
}
