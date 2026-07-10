

class Solution {
    public boolean hasDuplicate(int[] nums) {
        //a number is duplicate if the dictionary object can stack more than once
        HashSet<Integer> seenNumbers = new HashSet<>();
        for (int num : nums) {
            if(!seenNumbers.add(num)) {
                return true;
            }
        }
        return false;
    }
}