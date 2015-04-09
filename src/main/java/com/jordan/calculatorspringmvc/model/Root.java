/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jordan.calculatorspringmvc.model;

import java.util.Stack;
import org.nfunk.jep.ParseException;
import org.nfunk.jep.function.PostfixMathCommand;

/**
 *
 * @author Jordan
 */
public class Root extends PostfixMathCommand {

    public Root() {
        numberOfParameters = 2;
    }
    
    @Override
    public void run(Stack stack) throws ParseException {
        // check the stack
        checkStack(stack);

        // get the parameter from the stack
        Object param2 = stack.pop();    //param 2       radicando
        Object param1 = stack.pop();    //param 1       indice
        // check whether the argument is of the right type
        if (param1 instanceof Double && param2 instanceof Double) {
            // calculate the result
            double p1 = Double.valueOf(param1.toString());
            double p2 = Double.valueOf(param2.toString());
            double r = Math.pow(Math.E, Math.log(p2)/p1);
            // push the result on the inStack
            stack.push(r);
        } else {
            throw new ParseException("Invalid parameter type");
        }
    }

}