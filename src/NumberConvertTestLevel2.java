// This is the testing file for the level 2 NumberConvert.java

import java.util.Scanner;

public class NumberConvertTestLevel2 {
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
