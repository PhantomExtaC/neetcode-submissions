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
        
        /*
        N piles of bananas, each pile has piles[i] bananas 
        banana eating rate = k per hour
        optimal K for finishing all bananas ideally 
        should be the difference between the largest and smallest banana 
        and divided by the smallest pile, so that the monkey eats the bananas 
        in h hours, however we need to factor in the hours too
        lets assume there are 
        [2, 5, 6, 9, 8] bananas and h is 4
        this is not possible as h cannot exceed the individual no. of piles (logical fallacy)
        so the conditions are as follows 
        first determine the number of piles numPiles
        next we start finding the smallest and largest in a single pass
        next we code the main logic, here we need to understand exactly how we can
        a. D
        */
    }
}
