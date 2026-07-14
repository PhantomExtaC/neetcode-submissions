class Solution {
    public int climbStairs(int n) {
       if ( n <= 2) {
        return n;
       }
        //the function starts by creating three variables
       int oneStepBefore = 2;
       
       int twoStepsBefore = 1;
       int currentWays = 0;
        /*
        Why this works:
        Instead of starting at n and breaking it down recursively 
        (which wastes time recalculating the same steps ), 
        we start at the absolute smallest base cases.
        We know:

        Ways to reach Step 1 = 1

        Ways to reach Step 2 = 2

        To find Step 3, we simply add the ways to reach Step 1 and Step 2 
        (1 + 2 = 3).
        To find Step 4, we add Step 2 and Step 3 (2 + 3 = 5).
        We keep sliding this addition window up the stairs until we reach n. 
        This is DP in its most elegant, memory-efficient form.
        */
       for (int i = 3; i <= n; i++) {
        currentWays = oneStepBefore + twoStepsBefore;

        twoStepsBefore = oneStepBefore;
        oneStepBefore = currentWays;
       }
       return currentWays;
       
       /*
       How does the steps work
       At a time you can take 1 or 2 steps at a time 
       the distinct ways to reach the top 

       so here is my approach
       the number of distinct ways to reach the top are in a way, 
       compounding, i.e 
       it is a multiplication of the current choice and the remaining choices 
       like assume this, n = 4
       you can either take 2 steps or take 1 step 
       you take 2 steps, you have 2 more steps remaining 
       you take 1 step, you have 3 more steps remaining 
       from here on you have to look at the remaining steps as sub problems 
       so, if we assume 2 possibilities for each step, 
       either you take 
       1-1-1-1
       2-2
       2-1-1
       1-2-1
       1-1-2
       so posibilities = ?
       */ 
    }
}
