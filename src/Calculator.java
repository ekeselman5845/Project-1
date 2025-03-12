// To be awarded full credit for Level 4, you must demonstrate the following:
// 1. Loads the postfix expression onto a stack built into Java for solving.
// 2. Calculates the final value of the postfix expression using the stack algorithm.
// 3. Has a testing program in a Jar that accepts a string during the runtime in infix notation and
// then prints the result.

import java.util.*; 

public class Calculator {
    // Define operator precedence
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an infix expression: ");
        String input = scanner.nextLine().strip();
        scanner.close();

        try {
            // Step 1: Convert Infix to Postfix
            String postfix = InfixToPostfixConverter.infixToPostfix(input);
            System.out.println("Postfix expression: " + postfix);

            // Step 2: Evaluate Postfix Expression
            int result = evaluatePostfix(postfix);
            System.out.println("Solution: " + result);

        } catch (Exception e) {
            System.out.println("Invalid expression.");
        }
    }
    private static int evaluatePostfix(String postfix) {
        Deque<Integer> stack = new ArrayDeque<>();
        String[] tokens = postfix.split("\\s+");

        for (String token : tokens) {
            if (InfixToPostfixConverter.isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
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
        return stack.pop();
    }
}
