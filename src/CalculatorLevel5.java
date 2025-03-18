/*
 * To test Level 5 (which involves using my custom stack, MyStackLevel5), 
 * I created a new class named CalculatorLevel5.java. This new class uses my custom stack implementation instead of the built-in Deque.
*Below is the updated CalculatorLevel5.java, which replaces the built-in stack with my MyStackLevel5 stack:
 */

import java.util.Scanner;

public class CalculatorLevel5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an infix expression: ");
        String input = scanner.nextLine().strip();
        scanner.close();

        try {
            // Convert Infix to Postfix
            String postfix = InfixToPostfixConverter.infixToPostfix(input);
            System.out.println("Postfix expression: " + postfix);

            // Evaluate Postfix Expression using MyStackLevel5
            int result = evaluatePostfix(postfix);
            System.out.println("Solution: " + result);

        } catch (Exception e) {
            System.out.println("Invalid expression.");
        }
    }

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
