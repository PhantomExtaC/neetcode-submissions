class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];

        int prefix = 1;
        for (int i = 0; i < n; i++) {
            output[i] = prefix;
            prefix = prefix * nums[i];
        }

        int postfix = 1;
        for (int i = n - 1; i >= 0; i--) {
            output[i] = output[i] * postfix;
            postfix = postfix * nums[i];
        }
        return output;
        
        
        /*
        Here is my original concept, multiply all elements at once
        then for each index, devide the product by the value at the index
        but i suppose that is not the medium difficulty of this system
        So to not rely on the division operator, 
        maybe if we rely on some bitwise property and use substraction maybe?
        I cannot place my hand on it

        Ok, so the solution is kinda genius, 
        We have our answer array, and our goal is 
        for (int i = 0; i < n; i++) 
            we multiply everything to the right x output[i-1]
            store at output[i]
        
        */
    }
}  
