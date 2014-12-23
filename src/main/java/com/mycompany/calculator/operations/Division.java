/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.calculator.operations;

import com.mycompany.calculator.Operation;

/**
 *
 * @author Konst
 */
public class Division implements Operation {

    @Override
    public Double perform(Double a, Double b) {
        return a / b;
    }

    @Override
    public String getOperationSign() {
        return "/";
    }

}
