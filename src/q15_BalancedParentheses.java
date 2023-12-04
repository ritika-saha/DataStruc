import java.util.Stack;

public class q15_BalancedParentheses {

    public static void main(String[] args) {
        // Input the arithmetic expression
        String arithmeticExpression = "(5+6)*(7+8)/(4+3)(5+6)*(7+8)/(4+3)";

        // Check if the arithmetic expression has balanced parentheses
        boolean isBalanced = checkBalancedParentheses(arithmeticExpression);

        // Output the result
        if (isBalanced) {
            System.out.println("Arithmetic Expression is balanced.");
        } else {
            System.out.println("Arithmetic Expression is not balanced.");
        }
    }

    // Check if the arithmetic expression has balanced parentheses
    private static boolean checkBalancedParentheses(String expression) {
        Stack<Character> stack = new Stack<>();

        // Iterate through each character in the expression
        for (char ch : expression.toCharArray()) {
            if (ch == '(') {
                // If an open parenthesis is encountered, push it onto the stack
                stack.push(ch);
            } else if (ch == ')') {
                // If a closed parenthesis is encountered, pop from the stack
                // If the stack is empty, it means there is no matching open parenthesis
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        // If the stack is empty at the end, the parentheses are balanced
        return stack.isEmpty();
    }
}

