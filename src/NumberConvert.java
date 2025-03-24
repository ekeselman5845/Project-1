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

public class NumberConvert {

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

    public static String toBinary(int decimal) {
        return "0b" + Integer.toBinaryString(decimal);
    }

    public static String toOctal(int decimal) {
        return "0o" + Integer.toOctalString(decimal);
    }

    public static String toHex(int decimal) {
        return "0x" + Integer.toHexString(decimal).toUpperCase();
    }
   
}
