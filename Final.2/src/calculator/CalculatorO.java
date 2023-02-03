package calculator;

import java.util.Scanner;

public class CalculatorO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter your calculation (e.g. 2 + 2, 5 * 5, 9 / 3, 6 % 2):");
            String input = scanner.nextLine();
            String[] inputArray = input.split(" ");
            if (inputArray.length != 3) {
                System.out.println("Invalid input. Please try again.");
                continue;
            }
            try {
                double num1 = Double.parseDouble(inputArray[0]);
                double num2 = Double.parseDouble(inputArray[2]);
                String operator = inputArray[1];
                CalculationO calculation = new CalculationO(num1, num2, operator);
                System.out.println("Result: " + calculation.performCalculation());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please try again.");
                continue;
            }
        }
    }
}
