import java.util.Scanner;

public class example {
   public OperatorTokenRecognition() {
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Programming is running ");
      System.out.print("Enter an expression: ");
      String expression = scanner.nextLine();
      String[] tokens = expression.split("(?<=[-+*/^()])|(?=[-+*/^()])");
      String[] var7 = tokens;
      int var6 = tokens.length;

      for(int var5 = 0; var5 < var6; ++var5) {
         String token = var7[var5];
         token = token.strip();
         if (isOperator(token)) {
            System.out.println("Operator: " + token);
         } else if (isNumber(token)) {
            System.out.println("Number: " + token);
         } else {
            System.out.println("Invalid Token: " + token);
         }
      }

      scanner.close();
   }

   public static boolean isOperator(String token) {
      return token.matches("[\\(\\)\\^\\*\\/\\+\\-]");
   }

   public static boolean isNumber(String token) {
      return token.matches("-?\\d+");
   }

   public static String getOperatorType(String token) {
      switch (token) {
         case "(":
            return "Left Parenthesis";
         case ")":
            return "Right Parenthesis";
         case "*":
            return "Multiplication";
         case "+":
            return "Addition";
         case "-":
            return "Subtraction";
         case "/":
            return "Division";
         case "^":
            return "Exponent";
      }

      return "Unknown";
   }
}
