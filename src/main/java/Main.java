import java.util.Scanner;

public class Main {
  static Calculator calculator = new Calculator();
  public static void main(String[] args) {
    Scanner scanner=new Scanner(System.in);
    System.out.println("Welcome to the Calculator. Type your command:");

    while (true) {
      String input=scanner.nextLine().trim();

      // Split the input to get the command and parameters
      String[] parts=input.split(" ");
      if (parts.length < 2) {
        System.out.println("Invalid command. Please try again.");
        continue;
      }

      String command=parts[0];
      int result=0;

      try {
        switch (command) {
          case "add":
            if (parts.length == 3) {
              int a=Integer.parseInt(parts[1]);
              int b=Integer.parseInt(parts[2]);
              result= calculator.add(a, b);
              System.out.println(result);
            } else {
              System.out.println("Usage: add <num1> <num2>");
            }
            break;
          case "subtract":
            if (parts.length == 3) {
              int a=Integer.parseInt(parts[1]);
              int b=Integer.parseInt(parts[2]);
              result= calculator.subtract(a, b);
              System.out.println(result);
            } else {
              System.out.println("Usage: subtract <num1> <num2>");
            }
            break;
          case "multiply":
            if (parts.length == 3) {
              int a=Integer.parseInt(parts[1]);
              int b=Integer.parseInt(parts[2]);
              result=calculator.multiply(a, b);
              System.out.println(result);
            } else {
              System.out.println("Usage: multiply <num1> <num2>");
            }
            break;
          case "divide":
            if (parts.length == 3) {
              int a=Integer.parseInt(parts[1]);
              int b=Integer.parseInt(parts[2]);
              if (b != 0) {
                result= calculator.divide(a, b);
                System.out.println(result);
              } else {
                System.out.println("Error: Division by zero is not allowed.");
              }
            } else {
              System.out.println("Usage: divide <num1> <num2>");
            }
            break;
          case "fibonacci":
            if (parts.length == 2) {
              int n=Integer.parseInt(parts[1]);
              result=calculator.fibonacciNumberFinder(n);
              System.out.println(result);
            } else {
              System.out.println("Usage: fibonacci <num>");
            }
            break;
          case "binary":
            if (parts.length == 2) {
              int n=Integer.parseInt(parts[1]);
              String binaryResult=calculator.intToBinaryNumber(n);
              System.out.println(binaryResult);
            } else {
              System.out.println("Usage: binary <num>");
            }
            break;
          case "exit":
            System.out.println("Exiting the Calculator. Goodbye!");
            scanner.close();
            return;
          default:
            System.out.println("Unknown command: " + command);
            break;
        }
      } catch (NumberFormatException e) {
        System.out.println("Invalid number format. Please enter valid integers.");
      }
    }
  }
}
