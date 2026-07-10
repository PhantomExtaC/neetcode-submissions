class Solution {
    public boolean isPalindrome(String s) {
        //how we can begin, for palindrome, front to back == back to front
        // we can work with array, put the string in an array, and begin comparing front and back, 
        // if front == back, return true else false
        // now this will be O(n) complexity 
        //ALTERNATIVE
        // 
        int left = 0;
        int right = s.length()-1;

        while(left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;

        }
        return true;

    }
}
