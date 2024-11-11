package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the game number and press Enter\n1 - Greet\n2 - Even\n3 - Calc\n0 - Exit\n");
        int choise = scanner.nextInt();
        switch (choise) {
            case 1:
                Cli.greet();
                break;
            case 2:
                App.even();
                break;
            case 3:
                App.calc();
                break;
            case 0:
                System.out.println("Exiting the game. Goodbye!");
                break;
            default:
                System.out.println("Invalid choice! Please choose a valid game number.");
        }
        scanner.close();
    }
    private static void even() {

        int totalRounds = 3;
        final Random rANDOM = new Random();
        String userName = Cli.greet();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        for (int round = 0; round < totalRounds; round++) {
            int number = rANDOM.nextInt(100); // Генерация числа от 0 до 99
            System.out.println("Question: " + number);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine().trim().toLowerCase();

            String correctAnswer = (number % 2 == 0) ? "yes" : "no";

            if (!userAnswer.equals(correctAnswer)) {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return; // Завершение игры при неверном ответе
            }
            System.out.println("Correct!");
        }

        System.out.println("Congratulations, " + userName + "!");
        scanner.close();
    }

    private static void calc() {
        String[] operators = {"+", "-", "*"};
        int totalRounds = 3;
        final Random rANDOM = new Random();
        String userName = Cli.greet();
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the result of the expression?");
        for (int round = 0; round < totalRounds; round++) {
            int num1 = rANDOM.nextInt(50);
            int num2 = rANDOM.nextInt(50);
            String operation = operators[rANDOM.nextInt(operators.length)];
            int correctAnswer = calculate(num1, num2, operation);

            System.out.printf("Question: %d %s %d%n", num1, operation, num2);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();

            // Проверка, является ли ввод пользователя числом
            try {
                int userAnswerInt = Integer.parseInt(userAnswer);
                if (userAnswerInt == correctAnswer) {
                    System.out.println("Correct!");
                } else {
                    System.out.printf("'%s' is wrong answer ;(. Correct answer was '%d'.%n", userAnswer, correctAnswer);
                    System.out.printf("Let's try again, %s!%n", userName);
                    return; // Завершаем игру при неправильном ответе
                }
            } catch (NumberFormatException e) {
                System.out.printf("'%s' is not a valid number. Let's try again, %s!%n", userAnswer, userName);
                return; // Завершаем игру при неверном формате ответа
            }
        }
        System.out.printf("Congratulations, %s!%n", userName);
    }

    private static int calculate(int num1, int num2, String operation) {
        return switch (operation) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            default -> throw new IllegalArgumentException("Unsupported operation: " + operation);
        };
    }

}
