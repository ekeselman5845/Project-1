/*
 * Level 2 Goals – integer token recognition 
To be awarded full credit for Level 2, you must demonstrate the following: 
* 1. Recognizes strings of the following number types: binary, octal, hexadecimal, and decimal.  
You only need to accept integers; floating point numbers are not necessary.  You need to 
accept positive and negative numbers.  You may assume that the sign will be attached 
directly to the number without whitespace. 
*
*2. Stores the proper integer value of binary, octal, hexadecimal or decimal numbers that are 
negative or positive. 
a. You may want to make use of the Integer API reference: 
https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Integer.html 
b. parseInt() would be a useful function here before you complete your own algorithm 
as noted in #3. 

* 3. Implements your own class to convert a string containing a positive/negative binary, octal or 
hexadecimal number to decimal and the reverse.  Use this class in your project code. 

* 4. Has a testing program in a Jar that accepts a string during the runtime and then displays 
each operator token along with its type and value (for ints only).  Demonstrate that you can 
convert to/from decimal. 
 */

 /**
 * The NumberConvert class provides methods for converting numbers between different bases.
 * It supports conversion of binary, octal, hexadecimal, and decimal numbers.
 *
 * <p>This class can:
 * <ul>
 * <li>Convert a string representation of a number from binary, octal, hexadecimal, or decimal to decimal.</li>
 * <li>Convert a decimal integer to binary, octal, or hexadecimal representations.</li>
 * </ul>
 *
 * @author Elizabeth and Arjina
 */

public class NumberConvert {

      /**
     * Private constructor to fix javadoc warning. However, we still can finish our goal without this
     */
    private NumberConvert() {
        // This constructor is intentionally left empty.
    }

     /**
     * Converts a given string representation of a number in binary, octal, hexadecimal,
     * or decimal format to its integer decimal value.
     *
     * @param number The string representation of the number, prefixed appropriately (0b for binary, 0o for octal, 0x for hexadecimal).
     * @return The decimal integer value of the given number.
     * @throws NumberFormatException if the input format is invalid.
     */
    public static int toDecimal(String number) {
        if (number.startsWith("0b") || number.startsWith("-0b")) { //binary
            return Integer.parseInt(number.replaceFirst("0b", ""), 2);
        } else if (number.startsWith("0o") || number.startsWith("-0o")) { //octal
            return Integer.parseInt(number.replaceFirst("0o", ""), 8);
        } else if (number.startsWith("0x") || number.startsWith("-0x")) { //hexadecimal
            return Integer.parseInt(number.replaceFirst("0x", ""), 16);
        } else { //decimal
            return Integer.parseInt(number); 
        }
    }

     /**
     * Converts a decimal integer to its binary string representation, prefixed with "0b".
     *
     * @param decimal The decimal integer to be converted.
     * @return The binary string representation of the decimal number.
     */
    public static String toBinary(int decimal) {
        return "0b" + Integer.toBinaryString(decimal);
    }

      /**
     * Converts a decimal integer to its octal string representation, prefixed with "0o".
     *
     * @param decimal The decimal integer to be converted.
     * @return The octal string representation of the decimal number.
     */
    public static String toOctal(int decimal) {
        return "0o" + Integer.toOctalString(decimal);
    }

    /**
     * Converts a decimal integer to its hexadecimal string representation, prefixed with "0x".
     *
     * @param decimal The decimal integer to be converted.
     * @return The hexadecimal string representation of the decimal number, in uppercase format.
     */
    public static String toHex(int decimal) {
        return "0x" + Integer.toHexString(decimal).toUpperCase();
    }
   
}

// To run javadoc:  javadoc -d doc NumberConvert.java