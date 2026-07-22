class Solution {
    
    public int evalRPN(String[] tokens) {
       /*
       To understand RPN, we look at the example
       First, start pushing to stack,
       when first element comes, pop the recent two elements and perform the operation
       push the answer back to the stack
       repeat till all elements are not visisted
       we have the length of the input token as guideline
       */ 
       Stack<Integer> stack = new Stack<>();
       for (String token : tokens) {
            // If the token is an operator, pop two elements and compute
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } 
            else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } 
            else if (token.equals("-")) {
                // Order matters! 
                int b = stack.pop(); // The second operand
                int a = stack.pop(); // The first operand
                stack.push(a - b);
            } 
            else if (token.equals("/")) {
                // Order matters!
                int b = stack.pop(); 
                int a = stack.pop(); 
                stack.push(a / b);
            } 
            else {
                // If it's not an operator, it must be a number. Parse and push.
                stack.push(Integer.parseInt(token));
            }
        }
        
        // The final remaining element in the stack is the answer
        return stack.pop();
    }
}
