package com.company;

public class Main {


    public static void main(String[] argsOriginal) {
        try {
            String CalcLine = "5.1 + 1e-02";
            String[] args = CalcLine.split(" ");
            double argumentX = Double.parseDouble(args[0]);
            char operation = args[1].charAt(0);
            double argumentY = Double.parseDouble(args[2]);
            System.out.println(argumentX + " " + operation + " " + argumentY);
            System.out.println("Ответ: " + calc(argumentX, argumentY, operation));

        } catch (NumberFormatException ex) {
            System.out.println("Invalid number format!!!");
        }
    }

    private static double calc(double argumentX, double argumentY, char operation) {
        switch (operation) {
            case '+':
                return argumentX + argumentY;
            case '-':
                return argumentX - argumentY;
            case '*':
                return argumentX * argumentY;
            case '/':
                return argumentX / argumentY;
            default:
                return Double.NaN;
        }
    }

}
