// Liz File: Approach 1

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
