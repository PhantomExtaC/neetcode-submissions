class Solution {
    public int maxProfit(int[] prices) {
        /*
        My approach, Array given of n prices
        Goal is to find the smalles number, and then the largest number 
        that comes after the index of the smallest number
        so as standard, 
        */

        // Initialize min with the first element
        
        int min_index = 0;
        int max_index = 1;
        int maxProfit = 0;
        int profit = 0;
        //however there is one exception that comes to mind
        //what if the min is the last element in the array
        //in such case the entire operation will be run again, this introduces nesting
        // alternative strategy      
        while(max_index < prices.length) {
            if(prices[min_index] < prices[max_index]) {
                profit = prices[max_index] - prices[min_index];
                maxProfit = Math.max(maxProfit, profit);
            }
            else {
                min_index = max_index;
            }
            max_index++;
        }
        return maxProfit;

    }
}
