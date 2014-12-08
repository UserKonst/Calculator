/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.calculator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Konst
 */
public class Calculator {

    List<Operation> list = new ArrayList<>();

    public Calculator() {
        list.add(new Addition());
        list.add(new Subtracting());
        list.add(new Multiplication());
        list.add(new Division());
    }

    public String[] getOperations() {
        String[] operations = new String[list.size()];
        for (int i = 0; i < list.size(); i ++) {
            operations[i] = list.get(i).getOperationSign();
        }
        return operations;
    }

    public Double perform(String op, Double a, Double b) throws Exception {
        for (Operation o : list) {
            if (o.getOperationSign().equals(op)) {
                if (b == 0 && op.equals("/")) {
                    throw new ArithmeticException("EXCEPTION: Division by zero");
                }
                return o.perform(a, b);
            }
        }
        return null;
    }
}
