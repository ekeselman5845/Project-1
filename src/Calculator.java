// Level 4 Goals – solve postfix algorithm 
//To be awarded full credit for Level 4, you must demonstrate the following:
// 1. Loads the postfix expression onto a stack built into Java for solving.
// 2. Calculates the final value of the postfix expression using the stack algorithm.
// 3. Has a testing program in a Jar that accepts a string during the runtime in infix notation and
// then prints the result.

import java.util.*; 

 /**
 * This class represents a calculator that evaluates mathematical expressions written in postfix notation.
 * First, it converts an infix expression (example: "3 + 5 * (2 - 8)") to postfix notation,
 * and then evaluates the postfix expression to compute the result.
 * 
 * <p>
 * The calculator uses the InfixToPostfixConverter class to handle the conversion from infix to postfix notation.
 * Then it uses a stack to evaluate the postfix expression.
 * </p>
 */
public class Calculator {

     /**
     * This main method takes an infix expression from the user, and
     * converts it to postfix notation. 
     * Also, it evaluates the postfix expression.
     * 
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an infix expression: ");
        String input = scanner.nextLine().strip();
        scanner.close();

        try {
            // To convert infix to postfix
            String postfix = InfixToPostfixConverter.infixToPostfix(input);
            System.out.println("Postfix expression: " + postfix);

            // To evaluate postfix expression
            int result = evaluatePostfix(postfix);
            System.out.println("Solution: " + result);

        } catch (Exception e) {
            System.out.println("Invalid expression.");
        }
    }

     /**
     * This method evaluates a given postfix expression and returns the result.
     * 
     * @param postfix The postfix expression to evaluate.
     * @return The result of the postfix evaluation as an integer.
     * @throws IllegalArgumentException If the expression is invalid, or if contains unknown operators.
     */
    private static int evaluatePostfix(String postfix) {
        // Stack to hold intermediate results
        Deque<Integer> stack = new ArrayDeque<>();
        String[] tokens = postfix.split("\\s+"); // Split the postfix expression into tokens

        // To iterate through each token in the postfix expression
        for (String token : tokens) {
            if (InfixToPostfixConverter.isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
            // If the token is an operator, pop two operands from the stack and apply the operator
                int b = stack.pop();
                int a = stack.pop();
                switch (token) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(a / b); break;
                    case "^": stack.push((int) Math.pow(a, b)); break;
                    default: throw new IllegalArgumentException("Unknown operator: " + token);
                }
            }
        }
        
        // The result is the last value left in the stack
        return stack.pop();
    }
}

// To run the javadoc file: javadoc -d doc Calculator.java