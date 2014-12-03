/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.calculator;

/**
 *
 * @author Konst
 */
public interface Operation {

    Double perform(Double a, Double b);

    String getOperationSign();
}
