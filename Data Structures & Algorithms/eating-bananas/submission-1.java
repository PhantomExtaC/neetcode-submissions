class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int left = 1; 
        
        // The maximum possible eating speed is the largest pile
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        
        int result = right; // Default to the worst-case scenario
        
        // Binary Search for the optimal speed 'k'
        while (left <= right) {
            int k = left + (right - left) / 2;
            
            long hoursNeeded = 0; // Use long to prevent overflow on massive inputs
            for (int pile : piles) {
                // Calculate hours for this pile, rounding up
                hoursNeeded += Math.ceil((double) pile / k);
            }
            
            if (hoursNeeded <= h) {
                // This speed works! But can we do it even slower?
                result = k; 
                right = k - 1; // Try the lower half of the speed range
            } else {
                // This speed is too slow, we exceeded 'h' hours
                left = k + 1;  // Try the upper half of the speed range
            }
        }
        
        return result;
        
    }
}
