package hexlet.code;

import java.util.Scanner;

public class Cli {
    private static final Scanner scanner = new Scanner(System.in);

    public static String greet() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
        return name; // Возвращаем имя пользователя
    }
}
