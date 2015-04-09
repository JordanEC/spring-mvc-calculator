/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jordan.calculatorspringmvc.model;

import java.math.BigInteger;
import java.util.Stack;
import org.nfunk.jep.ParseException;
import org.nfunk.jep.function.PostfixMathCommand;

/**
 *
 * @author Jordan
 */
public class Factorial extends PostfixMathCommand {

    public Factorial() {
        numberOfParameters = 1;
    }

    @Override
    public void run(Stack stack) throws ParseException {
        // check the stack
        checkStack(stack);

        // get the parameter from the stack
        Object param = stack.pop();
        // check whether the argument is of the right type
        if (param instanceof Double) {
            // calculate the result
            double p1 = Double.valueOf(param.toString());
            if ((p1 % 1) != 0){
                stack.push("NaN");
                return;
            }
            int c;
            boolean positive = false;
            BigInteger inc = new BigInteger("1");
            BigInteger fact = new BigInteger("1");

            if (p1 == 0)
                stack.push(1);
            else {
                if (p1 > 0)
                    positive = true;
                else
                    p1 = p1 * -1;
                

                for (c = 1; c <= p1; c++) {
                    fact = fact.multiply(inc);
                    inc = inc.add(BigInteger.ONE);
                }

                if (!positive)
                    fact = fact.multiply(new BigInteger("-1"));
                
                stack.push(fact);
            }
        } else 
            stack.push("NaN");
        
    }

}
