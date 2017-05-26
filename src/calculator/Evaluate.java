/*
 * Programmer: Afonin, Anthony
 * Chemeketa Community College
 * Created: Wednesday, February 24, 2016 2:23:24 PM
 * Assignment: Calculator Final
 * File Name: Evaluate.java
 */

package calculator;

import javax.swing.*;

/**
 * Handles the pressed buttons of the Calculator GUI.
 */

public class Evaluate
{
	Calculator calc;
	String lastKey = new String();
	String stuff = new String();
	String temp;
	double sq;
	String operator;
	double result;
	double prevNum;
	double nextNum;
	double perc;

	/**
	 * Links the Evaluate class to the Java class.
	 */
	public Evaluate(Calculator id) 
	{
		calc = id;
	}

	/**
	 * SHandles the JButtons of the Calculator GUI.
	 */
	public void buildExpression(JButton button)
	{
		//Displays pressed button onto text field
		if (button.getText() == "1" || button.getText() == "2"
				||button.getText() == "3" || button.getText() == "4"
				|| button.getText() == "5" || button.getText() == "6" 
				|| button.getText() == "7" || button.getText() == "8"
				|| button.getText() == "9" || button.getText() == "0" 
				|| button.getText() == "(" || button.getText() == ")"
			    || button.getText() == ".")
		{
		    calc.text.setText(calc.text.getText() + button.getText());
			lastKey = button.getText();
			stuff += lastKey;
		}
		
		//Clears last entry
		else if (button.getText() == "CE")
		{
			calc.text.setText(calc.text.getText().substring(0, 
				calc.text.getText().length()-1));
		}
		
		//Clears text field
		else if (button.getText() == "C")
		{
			result = 0;
			prevNum = 0;
			nextNum = 0;
			perc = 0;
			calc.text.setText("");
			stuff = new String();
		}
		
		//Stores the number and operator inside the text in a variable
		if (button.getText() == "+" 
				|| button.getText() == "-" || button.getText() == "/" 
				|| button.getText() == "*" || button.getText() == "*"
				|| button.getText() == "m")
		{
			operator = button.getText();
		    prevNum = Double.parseDouble(calc.text.getText());
			calc.text.setText("");
		}
		
		//Squares the current number in the text field
		if (button.getText() == "^2")
		{
			sq = Double.parseDouble(calc.text.getText());
		    calc.text.setText(String.valueOf(sq * sq));
		}
		
		if (button.getText() == "%" )
		{
			try
			{
			    perc = Integer.parseInt(calc.text.getText());
				result = (perc / 100);
				calc.text.setText(String.valueOf(result));
			}
			catch(Exception e)
			{
			    perc = Double.parseDouble(calc.text.getText());
				result = (perc * 100);
				calc.text.setText(String.valueOf(result));
			}	
		}
		
		//Evaluates the expression
		if (button.getText() == "=")
		{
			result = 0;
			nextNum = Double.parseDouble(calc.text.getText());
			
			//Depending on the operator, calculates the result
			if (operator == "+" )
			{
			    result = (prevNum + nextNum);
			}
			
			else if (operator == "-")
			{
			    result = (prevNum - nextNum);
			}
			
			else if (operator == "/" )
			{
			    result = (prevNum / nextNum);
			}
			
			else if (operator == "/" )
			{
			    result = (prevNum / nextNum);
			}

			else if (operator == "*" )
			{
			    result = (prevNum * nextNum);
			}
			
			else if (operator == "m" )
			{
			    result = (prevNum % nextNum);
			}
			
			prevNum = nextNum;
			
			//Displays the result.
			calc.text.setText(String.valueOf(result));
		}
	}
}