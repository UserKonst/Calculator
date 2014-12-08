/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import com.mycompany.calculator.Calculator;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Конст
 */
public class CalculatorTest {

    public CalculatorTest() {
    }

    @Test(expected = ArithmeticException.class)
    public void Division_on_Zero_Should_Throw_Exceprion() throws Exception {
        
        Calculator calcualtor = new Calculator();
        Double result = calcualtor.perform("/", 2.0, 0.0);

    }

     @Test
    public void Two_plus_Two_Should_be_Four() throws Exception {
        
        Calculator calcualtor = new Calculator();

        Double result = calcualtor.perform("+", 2.0, 2.0);
        assertEquals("2+2 != 4", 4.0, result, 0.0);

    }
    
    
     @Test
    public void Minus_Two_Minus_Minus_Two_Should_be_Zero() throws Exception {
        
        Calculator calcualtor = new Calculator();

        Double result = calcualtor.perform("-", -2.0, -2.0);
        assertEquals("-2 -(-2)!= 0", 0.0, result, 0.0);

    }
    
      @Test
    public void Five_Multiply_by_Minus_Fife_Should_be_Minus_TwentyFive() throws Exception {
        
        Calculator calcualtor = new Calculator();

        Double result = calcualtor.perform("*", 5.0, -5.0);
        assertEquals("5 *(-5)!= -25", -25.0, result, 0.0);

    }
    
}
