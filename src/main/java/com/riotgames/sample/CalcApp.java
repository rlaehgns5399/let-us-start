package com.riotgames.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Calculator application
 */

public class CalcApp {
	public Stack<String> token_stack = new Stack<>();
	public ArrayList<String> token_array_string = new ArrayList<>();
	
	private boolean isDouble(String s){
		boolean result = false;
		
		try{
			Double.parseDouble(s);
			result = true;
		} catch(Exception e){
			result = false;
		}
		return result;
	}
	
    public double calc(String[] tokens) {
        
        for(int i = 0; i < tokens.length; i++){
        	if(tokens[i].equals("(")){
        		token_stack.push("(");
        	} else if(tokens[i].equals(")")){
        		while(!token_stack.peek().equals("(")){
        			token_array_string.add(token_stack.pop());
        		}
        		token_stack.pop();
        	} else if("+".equals(tokens[i]) || "/".equals(tokens[i]) || "-".equals(tokens[i]) || "x".equals(tokens[i])){
        		token_stack.push(tokens[i]);
        	} else if(isDouble(tokens[i]) == true){
        		token_array_string.add(tokens[i]);
        	} else {
        		System.err.println("Invaild Operator or Text");
        		break;
        	}
        }
        
        while(!token_stack.isEmpty()){
        	token_array_string.add(token_stack.pop());
        }
        
        System.out.println("");
        for(int i = 0; i < token_array_string.size(); i++){
        	System.err.print(token_array_string.get(i));
        }
        System.err.println("");
        double firstOperand, secondOperand;
        
        for(int i = 0; i < token_array_string.size(); i++){
        	String token = token_array_string.get(i);
        	if(token.equals("+") || token.equals("/") || token.equals("-") || token.equals("x")){
        		firstOperand = Double.parseDouble(token_stack.pop());
        		secondOperand = Double.parseDouble(token_stack.pop());
        		Operator operator = Operator.findOperator(token);
        		token_stack.push(Double.toString(operator.evaluate(firstOperand, secondOperand)));
        	} else {
        		token_stack.push(token);
        	}
        }
        
        return Double.parseDouble(token_stack.pop());
    }

    public static void main( String[] args ) {
        final CalcApp app = new CalcApp();
        final StringBuilder outputs = new StringBuilder();
        Arrays.asList(args).forEach(value -> outputs.append(value + " "));

	Logger logger = Logger.getLogger("StringPrint");

       	 
    }
}
