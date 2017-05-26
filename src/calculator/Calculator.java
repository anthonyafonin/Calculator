/*
 * Programmer: Afonin, Anthony
 * Chemeketa Community College
 * Created: Wednesday, February 24, 2016 2:23:24 PM
 * Assignment: Lab 13, Layout Managers, Part 3
 * File Name: Calculator.java
 */

package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *  A class that creates the GUI of a simple calculator.
 */
public class Calculator extends JPanel
{
	
	Evaluate eval = new Evaluate(this);
	
	private final int WIDTH = 500;
	private final int HEIGTH = 500; 
	JFrame frame = new JFrame();
	JTextField text = new JTextField();
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0;
	JButton button_mod, button_sq, button_mult, 
		button_div, button_add, button_sub, button_cl;
	JButton button_ca, button_equal, button_dot, 
		button_neg, button_par1, button_par2;
	String font;
	
	/**
	 * Create the user interface using a JFrame, JPanels and JButtons.
	 */
	public void createUserInterface()
	{
		//Adgusts frame;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane();
		frame.setSize(WIDTH, HEIGTH);
		
		//Create border and grid layout panels
		JPanel base = new JPanel (new BorderLayout());
		JPanel Border_1 = new JPanel (new BorderLayout());
		JPanel Border_2 = new JPanel (new BorderLayout());
		JPanel Grid_1 = new JPanel (new GridLayout(4, 3));
		JPanel Grid_2 = new JPanel (new GridLayout(5, 2));

		//Create the text field and alligns text to right.
		text.setHorizontalAlignment(SwingConstants.RIGHT);
		
		//Create operator buttons and gives labels.
		button_mod = new JButton("m");
		button_sq = new JButton("^2");
		button_mult = new JButton("*");
		button_div = new JButton("/");
		button_add = new JButton("+");
		button_sub = new JButton("-");
		button_cl = new JButton("CE");
		button_ca = new JButton("C");
		button_equal = new JButton("=");
		button_dot = new JButton(".");
		button_neg = new JButton("%");
		button_par1 = new JButton("(");
		button_par2 = new JButton(")");

		//Create number buttons
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");
		b0 = new JButton("0");
		
		//Create action listener for each button
		button_mod.addActionListener(new HandleKeyPress(button_mod));
		button_sq.addActionListener(new HandleKeyPress(button_sq));
		button_mult.addActionListener(new HandleKeyPress(button_mult));
		button_div.addActionListener(new HandleKeyPress(button_div));
		button_add.addActionListener(new HandleKeyPress(button_add));
		button_sub.addActionListener(new HandleKeyPress(button_sub));
		button_cl.addActionListener(new HandleKeyPress(button_cl));
		button_ca.addActionListener(new HandleKeyPress(button_ca));
		button_equal.addActionListener(new HandleKeyPress(button_equal));
		button_dot.addActionListener(new HandleKeyPress(button_dot));
		button_neg.addActionListener(new HandleKeyPress(button_neg));
		button_par1.addActionListener(new HandleKeyPress(button_par1));
		button_par2.addActionListener(new HandleKeyPress(button_par2));
		b1.addActionListener(new HandleKeyPress(b1));
		b2.addActionListener(new HandleKeyPress(b2));
		b3.addActionListener(new HandleKeyPress(b3));
		b4.addActionListener(new HandleKeyPress(b4));
		b5.addActionListener(new HandleKeyPress(b5));
		b6.addActionListener(new HandleKeyPress(b6));
		b7.addActionListener(new HandleKeyPress(b7));
		b8.addActionListener(new HandleKeyPress(b8));
		b9.addActionListener(new HandleKeyPress(b9));
		b0.addActionListener(new HandleKeyPress(b0));
		
		/* 
		 * change background color and font of each button.
		 * Also add action listener to buttons 0-9.
		 */
		//for (int i=0; i<10; i++) 
		//{
		//  b[i].setBackground(Color.WHITE);
		//	b[i].setFont(new Font("TimesRoman", Font.BOLD, 25));
		//	b[i].addActionListener(new HandleKeyPress(b[i]));
		//}

		//Changes color of "." and "±" buttons.
		button_dot.setBackground(Color.WHITE);
		button_neg.setBackground(Color.WHITE);

		//Places panels in frame and places grids in panels.
		frame.add(base);
		base.add(Border_1, BorderLayout.CENTER);
		base.add(Border_2, BorderLayout.EAST);
		Border_1.add(Grid_1, BorderLayout.CENTER);
		Border_2.add(Grid_2, BorderLayout.CENTER);

		//Place text field and equals button in base panel
		base.add(text, BorderLayout.NORTH);
		base.add(button_equal, BorderLayout.SOUTH);

		//Place Number buttons in left grid.
		Grid_1.add(b7);
		Grid_1.add(b8);
		Grid_1.add(b9);
		Grid_1.add(b4);
		Grid_1.add(b5);
		Grid_1.add(b6);
		Grid_1.add(b1);
		Grid_1.add(b2);
		Grid_1.add(b3);
		Grid_1.add(button_dot);
		Grid_1.add(b0);
		Grid_1.add(button_neg);

		//Place Operator buttons in right grid.
		Grid_2.add(button_cl);
		Grid_2.add(button_ca);
		Grid_2.add(button_mod);
		Grid_2.add(button_sq);
		Grid_2.add(button_par1);
		Grid_2.add(button_par2);
		Grid_2.add(button_mult);
		Grid_2.add(button_add);
		Grid_2.add(button_div);
		Grid_2.add(button_sub);

		//Set font for "." and "±" buttons.
		button_dot.setFont(new Font("TimesRoman", Font.BOLD, 35));
		button_neg.setFont(new Font("TimesRoman", Font.BOLD, 35));
		
		//Set font for buttons on left panel
		b1.setFont(new Font("TimesRoman", Font.BOLD, 35));
		b2.setFont(new Font("TimesRoman", Font.BOLD, 35));
		b3.setFont(new Font("TimesRoman", Font.BOLD, 35));
		b4.setFont(new Font("TimesRoman", Font.BOLD, 35));
		b5.setFont(new Font("TimesRoman", Font.BOLD, 35));
		b6.setFont(new Font("TimesRoman", Font.BOLD, 35));
		b7.setFont(new Font("TimesRoman", Font.BOLD, 35));
		b8.setFont(new Font("TimesRoman", Font.BOLD, 35));
		b9.setFont(new Font("TimesRoman", Font.BOLD, 35));
		b0.setFont(new Font("TimesRoman", Font.BOLD, 35));
		
		//set color for left panel
		b1.setBackground(Color.WHITE);
		b2.setBackground(Color.WHITE);
		b3.setBackground(Color.WHITE);
		b4.setBackground(Color.WHITE);
		b5.setBackground(Color.WHITE);
		b6.setBackground(Color.WHITE);
		b7.setBackground(Color.WHITE);
		b8.setBackground(Color.WHITE);
		b9.setBackground(Color.WHITE);
		b0.setBackground(Color.WHITE);
		
		//Set font for buttons on right panel.
		button_mod.setFont(new Font("TimesRoman", Font.BOLD, 35));
		button_sq.setFont(new Font("TimesRoman", Font.BOLD, 35));
		button_mult.setFont(new Font("TimesRoman", Font.BOLD, 35));
		button_div.setFont(new Font("TimesRoman", Font.BOLD, 35));
		button_add.setFont(new Font("TimesRoman", Font.BOLD, 35));
		button_sub.setFont(new Font("TimesRoman", Font.BOLD, 35));
		button_cl.setFont(new Font("TimesRoman", Font.BOLD, 35));
		button_ca.setFont(new Font("TimesRoman", Font.BOLD, 35));
		
		//Set font for text field and equals button.
		text.setFont(new Font("TimesRoman", Font.BOLD, 50));
		button_equal.setFont(new Font("TimesRoman", Font.BOLD, 50));

		//Sets frame to visible and names to Calculator.
		frame.setVisible(true);
		frame.setTitle("Calculator");
		
		//Adgusts the screen size when resized.
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = ( screen.width - WIDTH )/2;
		int y = ( screen.height - HEIGTH )/2;
		frame.setBounds( x, y, WIDTH,HEIGTH );
		frame.setSize(WIDTH, HEIGTH); 
	}

	public class HandleKeyPress implements ActionListener
	{
		JButton button;
		
		public HandleKeyPress(JButton id)
		{
			button = id;
		}
		
		public void actionPerformed(ActionEvent event)
		{
			eval.buildExpression(button);
		}
	}
	
	/**
	 * Create the main method and calls the GUI of the calculator.
	 */
	public static void main (String args[])
	{
		Calculator calc = new Calculator();
		calc.createUserInterface();
	}
}