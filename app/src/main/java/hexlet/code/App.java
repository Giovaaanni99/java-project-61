package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("""
                Please enter the game number and press Enter\

                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                6 - Prime
                0 - Exit
                Your choice:""");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                Cli.greet();
                break;
            case 2:
                App.even();
                break;
            case 3:
                App.calc();
                break;
            case 4:
                App.gcd();
                break;
            case 5:
                App.progression();
                break;
            case 6:
                App.prime();
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

    private static void gcd() {
        int totalRounds = 3;
        final Random rANDOM = new Random();
        String userName = Cli.greet();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Find the greatest common divisor of given numbers.");
        for (int round = 0; round < totalRounds; round++) {
            int num1 = rANDOM.nextInt(100);
            int num2 = rANDOM.nextInt(100);
            int correctNum = gcdCorrect(num1, num2);

            System.out.printf("Question: %d %s\n", num1, num2);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();

            try {
                int userAnswerInt = Integer.parseInt(userAnswer);
                if (userAnswerInt == correctNum) {
                    System.out.println("Correct!");
                } else {
                    System.out.printf("'%s' is wrong answer ;(. Correct answer was '%d'.%n", userAnswer, correctNum);
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

    private static int gcdCorrect(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;

    }

    private static void progression() {
        int totalRounds = 3;
        int maxLength = 10;
        int minLength = 5;
        final Random rANDOM = new Random();
        String userName = Cli.greet();
        Scanner scanner = new Scanner(System.in);
        for (int round = 0; round < totalRounds; round++) {
            int lengthProgression = rANDOM.nextInt(maxLength - minLength + 1) + minLength;
            int start = rANDOM.nextInt(20);
            int step = rANDOM.nextInt(5) + 1;
            int missingIndex = rANDOM.nextInt(lengthProgression);
            int[] progression = new int[lengthProgression];
            for (int i = 0; i < lengthProgression; i++) {
                progression[i] = start + i * step;
            }
            int missingNumber = progression[missingIndex];
            progression[missingIndex] = -1;
            System.out.println("What number is missing in the progression?");
            System.out.println("Question: ");
            printProgression(progression);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();

            try {
                int userAnswerInt = Integer.parseInt(userAnswer);
                if (userAnswerInt == missingNumber) {
                    System.out.println("Correct!");
                } else {
                    System.out.printf("'%s' is wrong answer ;(. Correct answer was '%d'.%n", userAnswer, missingNumber);
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

    private static void printProgression(int[] progression) {
        for (int number : progression) {
            if (number == -1) {
                System.out.print(".. ");
            } else {
                System.out.print(number + " ");
            }
        }
        System.out.println();
    }

    private static void prime() {
        int totalRounds = 3;
        final Random rANDOM = new Random();
        String userName = Cli.greet();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        for (int round = 0; round < totalRounds; round++) {
            int number = rANDOM.nextInt(100); // Генерация числа от 0 до 99
            System.out.println("Question: " + number);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine().trim().toLowerCase();
            boolean isPrime = isPrime(number);
            String correctAnswer = (isPrime) ? "yes" : "no";

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

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}







