class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int twoStepDown = 0;
        int oneStepDown = 0;

        for (int i = 2; i <= cost.length; i++) {
            int currentStep = Math.min(oneStepDown + cost[i - 1], twoStepDown + cost[i - 2]);
            twoStepDown = oneStepDown;
            oneStepDown = currentStep;
        }

        return oneStepDown;
        /*
        Here is what I infer
        We have a series of floors, each floor has a cost associated with it
        the ground floor is 0, and has cost cost[0]
        we HAVE TO pay the current floor ka cost and move ahead
        to move ahead, we can either skip a floor or we can entirely move
        one step at a time
        here is the deal, moving two steps at a time sounds ideal, 
        untill the even number steps have the max costs 
        and moving one step at a time doesnt make sense 
        so here is my interpretation 
        we know, that the best approach is the greedy approach, 
        so for each floor, compare the next floor, and the floor afters cost and store
        the lower cost is our preference and we return the sumCost

        Upgrade to the thinking, I UNDERSTAND DYNAMIC PROGRAMMING IN 1D HALLELUJAH
        So first off, we assume we start at the solution 
        thus sumCost = 0;
        next step, we find cost from step one before and two before
        cost[n]; cost[n-1]
        we see which is less expensive and add it to the sumCost
        sumCost = Math.min(cost[n-1], cost[n-2]);
        but since we have to do this recursively, we have to consider more
        for the steps before too
        so oneStepCost = 0;
        twoStepCost = 0;
        therefore
        sumCost = Math.min(oneStepCost + cost[n-1], twoStepCost + cost[n-2])

        */
    }
}
