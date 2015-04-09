/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jordan.calculatorspringmvc.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.nfunk.jep.JEP;


/**
 *
 * @author Jordan
 */
public class Calculator {
    private JEP parser;
    private String memory;

    public Calculator() {
        parser = new JEP();
        parser.initFunTab();                  // clear the contents of the function table
        parser.addStandardFunctions();
        parser.addStandardConstants();
        parser.addFunction("root", new Root());
        parser.addFunction("factorial", new Factorial());
        parser.setImplicitMul(true);
         memory = "0";
    }

    public String calculate(String op) {
        try {
            op = fixOperation(op);
            parser.parseExpression(op);
            String res = String.valueOf(parser.getValue());
            if(res == null)
                res = "Error de sintaxis";
            else{
                if(res.equalsIgnoreCase("Infinity") || res.equalsIgnoreCase("NaN"))
                    res = "Error matemático" ;
            }
            return fixResult(res);
        } catch (Exception ex) {
            return "Error de sintaxis";
        }
    }

    
    private String fixOperation(String op) throws Exception {
        String left, right;
        
        //%
        if (op.contains("%"))
            op = op.replaceAll("%", "/100");
        
        //²
        if(op.contains("²"))
            op=op.replaceAll("²", "^2");
        
        //³
        if(op.contains("³"))
            op=op.replaceAll("³", "^3");  
        
        //PI
        if(op.contains("π"))
            op = op.replaceAll("π", "pi");
        
        //ROOT
        while (op.contains("√")) {
            left = getLeftValue(op, "√");
            right = getRightValue(op, "√");
            op = op.replace(left+"√"+right, String.format("root(%s, %s)", left, right));
        }
        
        //!
        while(op.contains("!")){
            left = getLeftValue(op, "!");
            op = op.replace(left+"!", String.format("factorial(%s)", left));
        }
        
        return op;
    }

    private String getLeftValue(String op, String sign) throws Exception {
        int indexSign = op.indexOf(sign);
        try {
            if (indexSign == 0)
                throw new Exception();
            
            int indexStart = 0;
            for(int i = indexSign-1; i>-1; i--){
                if(op.charAt(i)== ' '){
                    indexStart = i;
                    break;
                }
            }
            
            return op.substring(indexStart, indexSign);
        } catch (IndexOutOfBoundsException e) {
            throw new Exception();
        }

    }

    private String getRightValue(String op, String sign) throws Exception {
        try {
            int indexSign = op.indexOf(sign);
            if(indexSign == op.length()-1)
                throw new Exception();
            
            int indexEnd = op.length();
            for(int i = indexSign+2; i < op.length() ; i++){
                if(op.charAt(i)== ' '){
                    indexEnd = i;
                    break;
                }
            }
            
            return op.substring(indexSign+1, indexEnd);
        } catch (IndexOutOfBoundsException e) {
            throw new Exception();
        }

    }

    public String memory(String mem, String value) {
        try {
            if(mem.equals("MC"))
                return memoryClear();
            
            if(mem.equals("MR"))
                return memoryRead();
            
            value = fixOperation(value);
            
            if(mem.equals("M+"))
                return memoryAdd(value);
            
            if(mem.equals("M-"))
                return memorySubtract(value);
            return "";
        } catch (Exception ex) {
            return "Error de sintaxis";
        }
    }

    private String memoryClear(){
        memory = "0";
        return memory;
    }
    
    private String memoryRead(){
        return memory;
    }
    
    private String memoryAdd(String value){
        parser.parseExpression(memory+"+"+value);
        memory = fixResult(String.valueOf(parser.getValue()));
        return memory;
    }
    
    private String memorySubtract(String value){
        parser.parseExpression(memory+"-"+value);
        memory = fixResult(String.valueOf(parser.getValue()));
        return memory;
    }
    
    private String fixResult(String re){
        if(re.endsWith(".0"))
            re = re.substring(0, re.length()-2);
        return re;
    }
}
