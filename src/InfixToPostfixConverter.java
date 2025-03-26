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

/**
 * InfixToPostfixConverter converts mathematical infix expressions to postfix notation.
 * It utilizes a stack to handle operator precedence and parentheses.
 * The program reads an infix expression from the user, converts it, and prints the postfix expression.
 */

public class InfixToPostfixConverter {
    /**
     * A map that defines the precedence of operators.
     * The higher the number, the higher the precedence of the operator.
     * 
     * Citation: 
     * https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Map.html
     * https://en.wikipedia.org/wiki/Shunting_yard_algorithm
     */
    private static final Map<String, Integer> precedence = Map.of(
        "^", 4,
        "*", 3,
        "/", 3,
        "+", 2,
        "-", 2,
        "(", 1,
        ")", 1
    );

    /**
     * Main method to run the program.
     * It accepts user input as an infix expression, and prints the corresponding postfix expression.
     *
     * @param args Command line arguments (not used in this program)
     */
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

    /**
     * To converts an infix expression to postfix.
     * 
     * This method reads through the infix expression, handles parentheses and operators,
     * and uses a stack to ensure that the operators appear in the correct order in the resulting
     * postfix expression. The method also considers operator precedence and handles different operator
     * types such as addition, subtraction, multiplication, and so on.
     *
     * @param infix The infix expression as a string (e.g., "3 + 5 * (2 - 8)").
     * @return The postfix expression as a string (e.g., "3 5 2 8 - * +").
     */
    public static String infixToPostfix(String infix) {
        Deque<String> stack = new ArrayDeque<>(); // Stack to store operators and parentheses
        StringBuilder postfix = new StringBuilder(); // StringBuilder for the postfix result
        StringBuilder currentToken = new StringBuilder(); // StringBuilder to handle digits in the expression
    
        // Loop through each character in the infix expression
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
    
             // If the character is a digit, build the current number token
            if (Character.isDigit(c)) {
                currentToken.append(c);
            } else {
                if (currentToken.length() > 0) {
                    postfix.append(currentToken).append(" ");
                    currentToken.setLength(0); //Reset
                }
                if (c == ' ') {
                    continue; //Skip spaces
                }    
                if (c == '(') {
                    stack.push(String.valueOf(c));
                } else if (c == ')') {
                    while (!stack.isEmpty() && !stack.peek().equals("(")) {
                        postfix.append(stack.pop()).append(" ");
                    }
                    stack.pop(); //Remove '(' from stack
                } else if (isOperator(String.valueOf(c))) {
                    //Handle negatives
                    if ((c == '-' || c == '+') && (i == 0 || infix.charAt(i - 1) == '(')) {
                        currentToken.append(c);
                        continue;
                    }
    
                    while (!stack.isEmpty() && precedence.get(stack.peek()) >= precedence.get(String.valueOf(c))) {
                        postfix.append(stack.pop()).append(" ");
                    }
                    stack.push(String.valueOf(c));
                }
            }
        }
        // to append any remaining number token to the postfix expression
        if (currentToken.length() > 0) { 
            postfix.append(currentToken).append(" ");
        }   
        // to pop all remaining operators from the stack
        while (!stack.isEmpty()) { 
            postfix.append(stack.pop()).append(" ");
        }
    
        return postfix.toString().trim();
    }

     /**
     * To check if the token is a valid number
     * This is used to differentiate between numbers and operators in the expression.
     * 
     * @param token The string token to check.
     * @return True if the token is a valid number, otherwise false.
     */
    public static boolean isNumber(String token) {
        try {
            Integer.parseInt(token); // try to parse as an integer
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * To checks if a string token is a valid operator.
     * An operator is one of the symbols defined in the precedence map.
     *
     * @param token The string token to check.
     * @return True if the token is a valid operator, otherwise false.
     */
    public static boolean isOperator(String token) {
        return precedence.containsKey(token);
    }
}

// Note to run the level 3 files. 
// to Level 3 compile: javac InfixToPostfixConverter.java
// to create the JAR file with the Level 3 manifest: MANIFEST.MF files created, 
// since we already have same name file so I named it MANIFEST_Level3.MF
// Create the JAR using MANIFEST_Level3.MF , used following commands
// jar cmf MANIFEST_Level3.MF InfixToPostfixConverter.jar InfixToPostfixConverter.class
// After creating JAR, Run the JAR file: java -jar InfixToPostfixConverter.jar

// Since we have created all the files, so just test run them using following.
// javac InfixToPostfixConverter.java
// java InfixToPostfixConverter
// java -jar InfixToPostfixConverter.jar
// To run the javadoc file: javadoc -d doc InfixToPostfixConverter.java

