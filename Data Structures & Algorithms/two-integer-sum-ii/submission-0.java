class Solution {
    public int[] twoSum(int[] numbers, int target) {
      int left = 0;
      int right = numbers.length - 1;

      while (left < right) {
        int sum = numbers[left] + numbers[right];

        if (sum == target) {
          return new int[] {left + 1, right + 1};
        } else if (sum < target) {
          left++;
        } else {
          right--;
        }
      }
      return new int[] {};
      
      /* 
      So here is a dilemma, 
      numbers is a set of integers sorted in increasing order
      so, goal is to find the one such number pair index of
      i and j such that i < j and numbers[i] + numbers[j] == k
      k is target
      my approach
      Searching takes O(n)
      but if we nest it inside a second search (we need two numbers)
      then it takes O(n^2)
      but since the entire array is sorted, that means, if we need to find the target, 
      we can use the method of elimination. 
      we have to return 2 indexes 
      so we approach in the same way as us trying to find the 
      two for loops (seprated)
      First one finds the tail end i.e the index where the number is no larger than the target
      after, we take first and last ka sum,
      WHILE (left < right && right <= tail)
      left = first elem
      right = tail elem
      sum = val(left + right)
      if sum == target
      return left, right
      else 
        if sum > target && left is at start
         dec right
        else if sum > target && right == left + 1
          dec right
        else if sum < target && right is at tail
          inc left
        else if sum < target && left == right - 1
          inc right

      but left cannot decrement more than 0th index, and right cannot increment more than tail index

      */  

    }
}
