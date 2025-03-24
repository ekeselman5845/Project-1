/* Name: Arjina and Elizabeth
* Project 1: Building a Calculator
 * Level 1 Goals – operator token recognition 
 *To be awarded full credit for Level 1, you must demonstrate the following:
 * 1. Has a CLI (textual, command line version) that accepts a string at runtime and uses built-in 
functions to split the string into tokens by space. 
 * a. You may want to make use of the String API reference: 
https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/String.html. 
 * b. split() and strip() would be useful functions here. 
 
 * 2. Recognizes the following operators: 
a. (  – left paren 
b. ) - – right paren 
c. ^ – exponentiation 
d. * – multiplication 
e. / – division
f. + - – addition
g. -  – subtraction 

 * 3. Has a testing program in a Jar that accepts a string during the runtime and then displays 
each operator token along with its type. 
 */
// This file runs both level 1 and level 2.

import java.util.Scanner;

/**
 * OperatorTokenRecognition class - Handles operator token recognition and number conversion.
 * 
 * <p>This program takes an arithmetic expression as input, tokenizes it, and identifies
 * whether each token is an operator or a number. If the token is a number, it converts
 * the number to decimal, binary, octal, and hexadecimal formats.</p>
 * 
 * <p>Supports recognition of the following operators: 
 * ( – Left Parenthesis, ) – Right Parenthesis, ^ – Exponentiation, * – Multiplication, 
 * / – Division, + – Addition, - – Subtraction.</p> */

public class OperatorTokenRecognition {

     /**
     * Default constructor for OperatorTokenRecognition.
     */
    public OperatorTokenRecognition() {
        // Default constructor to remove javaDoc warning. 
    }

     /**
     * Main method that processes user input, tokenizes it, and classifies tokens.
     * 
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        // Created a scanner to read input
        Scanner scanner = new Scanner(System.in);
        // for testing
        System.out.println("Programming is running ");

        // to prompt the user for an expression
        System.out.print("Enter an expression: ");
        String expression = scanner.nextLine();
        
        // Split the input expression by spaces
        //String[] tokens = expression.split("\\s+");
        String[] tokens = expression.split("(?<=[-+*/^()])|(?=[-+*/^()])");
        
        // Loop through the tokens and display the operator type
        for (String token : tokens) {
            token = token.strip(); // Remove leading/trailing whitespace
            
            // to check if the token is an operator
            if (isOperator(token)) {
                System.out.println("Operator: " + token);
            }
            // to check if the token is a number
            else if (isNumber(token)) {
                int decimal = NumberConvert.toDecimal(token);
                String binary = NumberConvert.toBinary(decimal);
                String octal = NumberConvert.toOctal(decimal);
                String hex = NumberConvert.toHex(decimal);
                System.out.print("Number: " + token);
                System.out.print("    Decimal: " + decimal);
                System.out.print("    Binary: " + binary);
                System.out.print("    Octal: " + octal);
                System.out.println("    Hexadecimal: " + hex);}
            else{
                System.out.println("Invalid Token: " + token);
            }
            
        }
        
        // to close the scanner to avoid resource leak
        scanner.close();
    }

     /**
     * Checks whether the given token is a recognized mathematical operator.
     * 
     * @param token The token to check.
     * @return true if the token is an operator, false otherwise.
     */
    public static boolean isOperator(String token) {
        return token.matches("[\\(\\)\\^\\*\\/\\+\\-]");
    }

     /**
     * Checks whether the given token is a valid number in binary, octal, hexadecimal, or decimal format.
     * 
     * @param token The token to check.
     * @return true if the token is a valid number, false otherwise.
     */
    public static boolean isNumber(String token) {
        return  token.matches("-?0b[01]+") ||  // Binary
                token.matches("-?0o[0-7]+") || // Octal
                token.matches("-?0x[0-9A-Fa-f]+") || // Hexadecimal
                token.matches("-?\\d+"); // Decimal
    }

     /**
     * Returns a descriptive name for a given operator token.
     * 
     * @param token The operator token.
     * @return A string describing the type of operator.
     */
    public static String getOperatorType(String token) {
        switch (token) {
            case "+": return "Addition";
            case "-": return "Subtraction";
            case "*": return "Multiplication";
            case "/": return "Division";
            case "^": return "Exponent";
            case "(": return "Left Parenthesis";
            case ")": return "Right Parenthesis";
            default: return "Unknown";
        }
}
}
// javac OperatorTokenRecognition.java
// this line helps to create a .class file 
// to run the JAR File for both level 1 and level 2
// java -jar Goal1.jar
// java -jar Goal2.jar

// to run the javaDoc:  javadoc -d doc OperatorTokenRecognition.java