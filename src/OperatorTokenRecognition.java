
import java.util.Scanner;

public class OperatorTokenRecognition {
    
    public static void main(String[] args) {
// for testing
//System.out.println("Testing is running ");
        // Create a scanner to read input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Programming is running ");
        // Prompt the user for an expression
        System.out.print("Enter an expression: ");
        String expression = scanner.nextLine();
        
        // Split the input expression by spaces
        //String[] tokens = expression.split("\\s+");
        String[] tokens = expression.split("(?<=[-+*/^()])|(?=[-+*/^()])");
        
        // Loop through the tokens and display the operator type
        for (String token : tokens) {
            token = token.strip(); // Remove leading/trailing whitespace
            
            // Check if the token is an operator
            if (isOperator(token)) {
                System.out.println("Operator: " + token);
            }
            // Check if the token is a number
            else if (isNumber(token)) {
                int decimal = NumberConvert.toDecimal(token);
                String binary = NumberConvert.toBinary(decimal);
                String octal = NumberConvert.toOctal(decimal);
                String hex = NumberConvert.toHex(decimal);
                System.out.print("Number: " + token);
                System.out.print("    Decimal: " + decimal);
                System.out.print("    Binary: " + binary);
                System.out.print("    Octal: " + octal);
                System.out.println("    Hexadecimal: " + hex);
            }
            else {
                System.out.println("Invalid Token: " + token);
            }
            
        }
        
        // Close the scanner to avoid resource leak
        scanner.close();
    }

    // Helper method to check if the token is an operator
    public static boolean isOperator(String token) {
        return token.matches("[\\(\\)\\^\\*\\/\\+\\-]");
    }

    // Helper method to check if the token is a valid number
    public static boolean isNumber(String token) {
        return  token.matches("-?0b[01]+") ||  // Binary
                token.matches("-?0o[0-7]+") || // Octal
                token.matches("-?0x[0-9A-Fa-f]+") || // Hexadecimal
                token.matches("-?\\d+"); // Decimal
    }

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
// to run the JAR File
// java -jar OperatorTokenRecognition.jar