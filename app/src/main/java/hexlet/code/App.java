package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the game number and press Enter\n1 - Greet\n2 - Even\n0 - Exit\n");
        int choise = scanner.nextInt();
        switch (choise) {
            case 1:
                Cli.greet();
                break;
            case 2:
                App.even();
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
        //Scanner userNme = userName.getUserName();
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

}
