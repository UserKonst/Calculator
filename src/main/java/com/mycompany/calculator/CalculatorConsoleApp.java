/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.calculator;

import java.util.Scanner;

/**
 *
 * @author Konst
 */
public class CalculatorConsoleApp {

    static Calculator calculator;
    static String operation = null;

    public static void main(String[] args) throws Exception {
        
                calculator = new Calculator();

        do {
            Scanner sc = new Scanner(System.in);
            // greatings
            System.out.println("*** Greetings ***");

            // print operations
            System.out.println("Available operations:");

            for (String op : calculator.getOperations()) {
                System.out.print(op);
                System.out.print(" ");
            }
            //------------------------------------------------------------

            // check operation sign
            while ( ! checkOperation(sc.nextLine())) {
                System.out.println("There isn't such operation");
            }
          
            //Read operation
            if ("exit".equalsIgnoreCase(operation)) {
                System.out.println("See you!");
                break;
            }

            //Read values, perform operation, write it 
            // Read first value
            System.out.println("Input first value");
            Double firstValue;
            while ( ! sc.hasNextDouble()) {
                System.out.println("only Double");
                sc.next();
            }
            firstValue = sc.nextDouble();

            // Read second value
            System.out.println("Input second value");
            Double secondValue;
            while ( ! sc.hasNextDouble()) {
                System.out.println("only Double");
                sc.next();
            }
            secondValue = sc.nextDouble();

            try {
                //Perform operation
                System.out.print("\n "
                    + firstValue + " "
                    + operation + " "
                    + secondValue + " = "
                    + calculator.perform(operation, firstValue, secondValue) + "\n");
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
            sc.reset();
            System.out.println("-------------------------");
        } while (true);
    }

    private static boolean checkOperation(String op) {

        for (String st : calculator.getOperations()) {
            if (op.equals(st) || op.equals("exit")) {
                operation = op;
                return true;
            }
        }
        return false;
    }
    
}
