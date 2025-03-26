// This is the testing file for the level 2 NumberConvert.java

import java.util.Scanner;
/**
 * The {@code NumberConvertTestLevel2} class serves as a test program for the {@link NumberConvert} class.
 * It allows users to input a number in various formats (binary, octal, hexadecimal, or decimal)
 * and converts it into equivalent representations in other bases.
 *
 * @author Arjina and Elizabeth
 * @version 1.0
 */
public class NumberConvertTestLevel2 {

    /**
    * Default constructor just to avoid javadoc warning. 
    */
    public NumberConvertTestLevel2() {
    // Default constructor does not need additional setup.
    }

    /**
     * The main method serves as the entry point of the program.
     * It prompts the user to enter a number, converts it into different bases, and prints the results.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number (binary: 0b, octal: 0o, hex: 0x, or decimal): ");
        String input = scanner.nextLine();

        try {
            int decimalValue = NumberConvert.toDecimal(input);
            System.out.println("Decimal equivalent: " + decimalValue);
            System.out.println("Binary equivalent: " + NumberConvert.toBinary(decimalValue));
            System.out.println("Octal equivalent: " + NumberConvert.toOctal(decimalValue));
            System.out.println("Hexadecimal equivalent: " + NumberConvert.toHex(decimalValue));
        } catch (NumberFormatException e) {
            System.out.println("Invalid input format.");
        }

        scanner.close();
    }
}

// to create jar file: jar cfe NumberConvertTestLevel2.jar NumberConvertTestLevel2 *.class
// to run the javadoc file: javadoc -d doc NumberConvertTestLevel2.java