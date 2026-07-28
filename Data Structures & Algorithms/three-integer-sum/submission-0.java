class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
        For this problem we can assume straightforward that
        a, b c are solution numbers
        a + b = -c 
        so with this in mind, we just have to switch the target of the two sum to be 
        the negation of the third number (consider that without a single number being in the list
        we will not meet the criteria of a + b + c = 0)
        so with that in place lets write down the structured approach for a two sum


        */
List<List<Integer>> result = new ArrayList<>();
        
        // Step 1: Sort the array. This is critical for avoiding duplicates and using two pointers.
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Optimization & Deduplication: If the current number is the same as the previous, skip it.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Step 2: Use the Two-Pointer technique on the remaining part of the array
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    // We found a valid triplet!
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Deduplication: Skip any duplicate numbers for the 'left' pointer
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Deduplication: Skip any duplicate numbers for the 'right' pointer
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    
                    // Move both pointers inward to look for other potential pairs
                    left++;
                    right--;
                } else if (sum < 0) {
                    // Sum is too small, we need a bigger number
                    left++;
                } else {
                    // Sum is too big, we need a smaller number
                    right--;
                }
            }
        }
        
        return result;
    }
}
