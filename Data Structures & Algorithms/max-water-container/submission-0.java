class Solution {
    public int maxArea(int[] heights) {
        /*
        the premise of the problem is to find two largest points soo far apart
        that the product is maximum, 
        so can I apply maybe a principle of maximization? No the array isnt sorted or 
        a regular function output
        the alternative is, we look at it as is, 
        whe initialize left as 0, we initialize right as length - 1;
        while left < right
        if area of left + 1 > area left, area = area of left + 1, else leave left as is and check for right
        if area of right + 1 > right, area = area of right, else leave as is 
        return area

        I can see the potential infinite loop in this setup tho
        */
        
        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;

        while (left < right) {
            int currentWidth = right - left;
            int currentHeight = Math.min(heights[left], heights[right]);
            int currentArea = currentWidth * currentHeight;

            maxArea = Math.max(maxArea, currentArea);

            if(heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
            
        }
        return maxArea;

    }
}
