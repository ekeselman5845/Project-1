/*Level 5 Goals – your stack and packaging 
* 1. Replace the built-in stack with a stack implemented by your team.  It can be a LinkedList- or 
  Array-based stack. Your stack should also implement the Stack interface.  If you have 
  implemented the previous code correctly, there should be very few modifications to 
  substitute your stack. 
* 2. Has appropriate JavaDoc documentation for all classes. 
* 3. Has all necessary source code. 
* 4. Has an executable Jar. 
* 5. Has screenshots demonstrating successful operation of Goal 1, 2, 3, and 4. 
* 6. Has a weekly log of accomplishments, with each group member appropriately attributed.
*/

/*
 * To test Level 5 (which involves using my custom stack, MyStackLevel5), 
 * We created a new class named CalculatorLevel5.java. This new class uses my custom stack implementation instead of the built-in Deque.
 *Below is the updated CalculatorLevel5.java, which replaces the built-in stack with my MyStackLevel5 stack:
 */

import java.util.Scanner;
/**
 * The CalculatorLevel5 class provides functionality to evaluate infix expressions
 * using a custom stack implementation, MyStackLevel5.
 * 
 * It first converts the infix expression to postfix notation and then evaluates
 * the postfix expression using the custom stack. The program expects the user to
 * input an infix expression and outputs the corresponding postfix expression and
 * the result of the evaluation.
 *
 * <p>
 * This class replaces the built-in stack with a custom stack implementation.
 * </p>
 * 
 * @author Arjina and Elizabeth
 * @version 1.0
 * @since 03-25-2025
 */

public class CalculatorLevel5 {

     /**
     * This main method takes input from the user in infix notation, converts it to
     * postfix notation, and evaluates the postfix expression.
     * 
     * @param args Command line arguments (not used).
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

            // To evaluate postfix expression using MyStackLevel5
            int result = evaluatePostfix(postfix);
            System.out.println("Solution: " + result);

        } catch (Exception e) {
            System.out.println("Invalid expression.");
        }
    }

      /**
     * To Evaluate the given postfix expression using a custom stack implementation.
     * 
     * @param postfix The postfix expression to evaluate.
     * @return The result of the postfix expression evaluation.
     * @throws IllegalArgumentException if an unknown operator is encountered in the expression.
     */

    private static int evaluatePostfix(String postfix) {
        // Use custom stack MyStackLevel5 instead of built-in Deque
        MyStackLevel5<Integer> stack = new MyStackLevel5<>();
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

// to create jar file for level 5
// 1. created the manifestlevel5.txt file
// 2. then created the jar file using following command
// jar cfm CalculatorLevel5.jar manifestlevel5.txt *.class
// 3. to run the jar file: java -jar CalculatorLevel5.jar
// To run JavaDoc: javadoc -d doc MyStackLevel5.java CalculatorLevel5.java

