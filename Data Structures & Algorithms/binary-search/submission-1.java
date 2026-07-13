class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0){
            return -1;
        }
        else if (n == 1) {
            if (nums[0] == target) {
                return 0;
            }
            return -1;
        }
        else {
            int left = 0;
            int right = nums.length - 1;
        
        while (left <= right) {
            // Prevents integer overflow for extremely large arrays
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid; // Target found
            } else if (nums[mid] < target) {
                // Target is in the right half, discard the left half
                left = mid + 1;
            } else {
                // Target is in the left half, discard the right half
                right = mid - 1;
            }
        }
        
        // Target does not exist in the array
        return -1;
        }
    }
}

 /*
        A simple binary search
        first we determine if nums is empty, 
        if empty return -1
        else 
        if only one element, 
        compare with target
        if matched return target
        else return -1
        final check (main binary implementation)
        n = sizeOf nums
        int left = 0;
        int right = n - 1;
        while (left < right) {
        if(target == nums[(right-left)/2])
        return target
        else if (target > nums[(right - left)/2])
        left = (right - left) /2
        else
        right = (right - left) /2
        }
        */
