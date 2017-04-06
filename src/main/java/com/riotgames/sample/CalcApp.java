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
	public Stack<String> tokenStack = new Stack<>();
	public ArrayList<String> tokenArrayString = new ArrayList<>();

	private boolean isDouble(String s) {
		boolean result = false;

		try {
			double temp = Double.parseDouble(s);
			if(Double.isNaN(temp)) return false;
			result = true;
		} catch (Exception e) {
			result = false;
		}
		return result;
	}

    public double calc(String[] tokens) {
        
        for(int i = 0; i < tokens.length; i++){
        	if("(".equals(tokens[i])){
        		tokenStack.push("(");
        	} else if(")".equals(tokens[i])){
        		while(!"(".equals(tokenStack.peek())){
        			tokenArrayString.add(tokenStack.pop());
        		}
        		tokenStack.pop();
        	} else if("+".equals(tokens[i]) || "/".equals(tokens[i]) || "-".equals(tokens[i]) || "x".equals(tokens[i])){
        		tokenStack.push(tokens[i]);
        	} else if(isDouble(tokens[i]) == true){
        		tokenArrayString.add(tokens[i]);
        	} else {
        		Logger logger = Logger.getLogger("Error");
        		String result="Invaild Operator";
        		logger.log(Level.INFO,result);
        		break;
        	}
        }
        
        while(!tokenStack.isEmpty()){
        	tokenArrayString.add(tokenStack.pop());
        }
        

        double firstOperand;
        double secondOperand;
        
        for(int i = 0; i < tokenArrayString.size(); i++){
        	String token = tokenArrayString.get(i);
        	if("+".equals(token) || "/".equals(token) || "x".equals(token) || "-".equals(token)){
        		firstOperand = Double.parseDouble(tokenStack.pop());
        		secondOperand = Double.parseDouble(tokenStack.pop());
        		Operator operator = Operator.findOperator(token);
        		tokenStack.push(Double.toString(operator.evaluate(firstOperand, secondOperand)));
        	} else {
        		tokenStack.push(token);
        	}
        }
        
        return Double.parseDouble(tokenStack.pop());
    }

    public static void main( String[] args ) {
        final CalcApp app = new CalcApp();
        final StringBuilder outputs = new StringBuilder();
        Arrays.asList(args).forEach(value -> outputs.append(value + " "));
	
		Logger logger = Logger.getLogger("StringPrint");
		
		String result="Addition of value : "+outputs+" = "+Double.toString(app.calc(args));
		logger.log(Level.INFO,result);
    }
}
