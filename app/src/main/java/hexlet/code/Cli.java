package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void Talk() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Welcome to the Brain Games!\nMay I have your name? ");

        String name = scanner.nextLine();

        System.out.print("Hello," + name + "!" + "\n" );
        System.out.println();

        scanner.close();

    }
}