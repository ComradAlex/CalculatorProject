import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int number1 = GettingSymbols.getInt();
        int number2 = GettingSymbols.getInt();
        char operation = GettingSymbols.getOperation();
        int result = Calculations.calculate(number1,number2,operation);
        System.out.println("Result of calculations: "+result);
    }

    private static class GettingSymbols {

        public static int getInt() {
            System.out.println("Enter the number:");
            int num;
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
            } else {
                System.out.println("The number is incorrect. Try again");
                scanner.next();
                num = getInt();
            }
            return num;
        }

        public static char getOperation() {
            System.out.println("Enter the operation:");
            char operation;
            if (scanner.hasNext()) {
                operation = scanner.next().charAt(0);
            } else {
                System.out.println("The operation is incorrect. Try again.");
                scanner.next();
                operation = getOperation();
            }
            return operation;
        }
    }

    public static class Calculations {

        public static int calculate(int number1, int number2, char operation) {
            int result;
            switch (operation) {
                case '+':
                    result = number1 + number2;
                    break;
                case '-':
                    result = number1 - number2;
                    break;
                case '*':
                    result = number1 * number2;
                    break;
                case '/':
                    result = number1 / number2;
                    break;
                default:
                    System.out.println("Operation is incorrect. Try again.");
                    result = calculate(number1, number2, GettingSymbols.getOperation());
            }
            return result;
        }
    }
}

