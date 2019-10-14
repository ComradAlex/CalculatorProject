import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int number1 = GettingSymbols.getInt();
        int number2 = GettingSymbols.getInt();
        char operation = GettingSymbols.getOperation();
        int result = Calculations.calculate(number1,number2,operation);
        System.out.println("Результат операции: "+result);
    }

    private static class GettingSymbols {

        public static int getInt() {
            System.out.println("Введите число:");
            int num;
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
            } else {
                System.out.println("Неверно введено число. Повторите попытку.");
                scanner.next();
                num = getInt();
            }
            return num;
        }

        public static char getOperation() {
            System.out.println("Введите операцию:");
            char operation;
            if (scanner.hasNext()) {
                operation = scanner.next().charAt(0);
            } else {
                System.out.println("Неверно введена операция. Повторите попытку.");
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
		case "abs":
                    result = Math.abs(number1);
                    break;
                case "%":
                    result = number1 % number2;

                default:
                    System.out.println("Операция не распознана. Повторите ввод.");
                    result = calculate(number1, number2, GettingSymbols.getOperation());
            }
            return result;
        }
    }
}

