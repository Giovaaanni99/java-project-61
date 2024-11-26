package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Cli;

public class Calc {
    static final String RULES = "What is the result of the expression?";
    static final String[] OPERATORS = {"+", "-", "*"};

    public static void run() {
        var rounds = new String[Engine.NUM_OF_ROUNDS][2];

        for (var i = 0; i < rounds.length; i += 1) {
            rounds[i] = generateRound();
        }

        Engine.runGame(RULES, rounds);
    }

    private static String[] generateRound() {
        var operand1 = Cli.generateRandomNumber();
        var operand2 = Cli.generateRandomNumber();
        var operator = OPERATORS[Cli.generateRandomNumber(0, OPERATORS.length)];
        var rightAnswer = "" + calculateRightAnswer(operand1, operand2, operator);
        var question = operand1 + " " + operator + " " + operand2;

        return new String[]{question, rightAnswer};
    }

    private static int calculateRightAnswer(int operand1, int operand2, String operator) {
        return switch (operator) {
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            case "*" -> operand1 * operand2;
            default -> throw new RuntimeException("Unknown operator");
        };
    }
}
