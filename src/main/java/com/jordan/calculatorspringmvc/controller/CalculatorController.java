/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jordan.calculatorspringmvc.controller;

import com.jordan.calculatorspringmvc.model.Calculator;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Jordan
 */
@Controller
@Scope("session")
public class CalculatorController{
    Calculator calculator;
    
    public CalculatorController() {
        calculator = new Calculator();
    }
    
    
    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("index");
        return mv; 
    }
    
    @RequestMapping(value="/calcular", method = RequestMethod.POST)
    public @ResponseBody String calcular(@RequestParam("op") String op){
        return calculator.calculate(op);
    }

    @RequestMapping(value="/memory", method = RequestMethod.POST)
    public @ResponseBody String memory(@RequestParam("mem") String mem, @RequestParam("value") String value){
        return calculator.memory(mem, value);
    }
}
