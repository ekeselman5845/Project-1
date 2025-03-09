//Level 3 Goals – infix to postfix algorithm 
//1. Loads the ints and operators into a stack built into Java. 
/*a. You may want to make use of the Deque API reference: 
https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Deque.html.  
b. You will also want to make use of the Stack object type and the functions in this 
interface.  (This will allow us to easily substitute the data structure later.)  The API 
reference is here: 
https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Stack.html.  
2. Converts an expression from infix to postfix. 
3. 3. Has a testing program in a Jar that accepts a string during the runtime in infix notation and 
then displays a string in postfix notation. 
*/


import java.util.*;

public class InfixToPostfixConverter {
    // to define operator precedence
    private static final Map<String, Integer> precedence = Map.of(
        "^", 4,
        "*", 3,
        "/", 3,
        "+", 2,
        "-", 2,
        "(", 1,
        ")", 1
    );

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an infix expression: ");
        String input = scanner.nextLine().strip();

        try {
            String postfix = infixToPostfix(input);
            System.out.println("Postfix expression: " + postfix);
        } catch (Exception e) {
            System.out.println("Invalid expression.");
        }
        
        scanner.close();
    }

    // to convert infix expression to postfix
    private static String infixToPostfix(String infix) {
        Deque<String> stack = new ArrayDeque<>();
        StringBuilder postfix = new StringBuilder();
        
        String[] tokens = infix.split("\\s+");
        
        for (String token : tokens) {
            if (isNumber(token)) {
                // If token is a number, add to the output
                postfix.append(token).append(" ");
            } else if (token.equals("(")) {
                // If token is left parenthesis, push onto stack
                stack.push(token);
            } else if (token.equals(")")) {
                // If token is right parenthesis, pop from stack until left parenthesis
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.pop(); // This will help to discard the left parenthesis
            } else if (isOperator(token)) {
                // If token is an operator
                while (!stack.isEmpty() && precedence.get(stack.peek()) >= precedence.get(token)) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(token);
            }
        }

        // POP all the operators left in the stack
        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
        }

        return postfix.toString().trim(); // Return the postfix expression
    }

    // to check if the token is a number
    private static boolean isNumber(String token) {
        try {
            Integer.parseInt(token); // try to parse as an integer
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // to check if the token is an operator
    private static boolean isOperator(String token) {
        return precedence.containsKey(token);
    }
}

