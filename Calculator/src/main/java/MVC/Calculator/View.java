package MVC.Calculator;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class View extends JFrame{

	//Components
	private JLabel firstNumber, secondNumber, answerLabel, symbolLabel;
	private JButton buttons[];
	private JPanel labelsJP, buttonsJP;
	
	//Fonts
	Font button = new Font("Arial", 0, 12);
	Font label = new Font("Arial", 1, 12);
	
	
	public View(){
		
		//Frame Layout 
		setBackground(Color.GRAY);
		
		//labels panel
		labelsJP = new JPanel();
		
		firstNumber = new JLabel("0");
		firstNumber.setHorizontalTextPosition(JLabel.RIGHT);
		firstNumber.setHorizontalAlignment(JLabel.RIGHT);
		firstNumber.setOpaque(true);
		firstNumber.setBackground(Color.WHITE);
		
		secondNumber = new JLabel("0");
		secondNumber.setHorizontalTextPosition(JLabel.RIGHT);
		secondNumber.setHorizontalAlignment(JLabel.RIGHT);
		secondNumber.setOpaque(true);
		secondNumber.setBackground(Color.WHITE);
		
		answerLabel = new JLabel("0");
		answerLabel.setHorizontalTextPosition(JLabel.RIGHT);
		answerLabel.setHorizontalAlignment(JLabel.RIGHT);
		answerLabel.setOpaque(true);
		answerLabel.setBackground(Color.WHITE);
		
		symbolLabel = new JLabel(" ");
		symbolLabel.setSize(5, 10);
		symbolLabel.setHorizontalTextPosition(JLabel.LEFT);
		symbolLabel.setOpaque(true);
		symbolLabel.setBackground(Color.WHITE);
		
		labelsJP = new JPanel();
		labelsJP.setLayout(new GridLayout(4, 1, 2, 2));
		labelsJP.add(firstNumber);
		labelsJP.add(symbolLabel);
		labelsJP.add(secondNumber);
		labelsJP.add(answerLabel);
		
		//Buttons Panel
		buttonsJP = new JPanel();
		JPanel auxControl = new JPanel();
		JPanel auxOutput = new JPanel();
		
		//Buttons
		buttons = new JButton[23];
		
		for(int i = 0;i < 10;i++){
			buttons[i] = new JButton(String.valueOf(i));
		}
		buttons[10] = new JButton("+");
		buttons[11] = new JButton("-");
		buttons[12] = new JButton("*");
		buttons[13] = new JButton("/");
		buttons[14] = new JButton("-/+");
		buttons[15] = new JButton(".");
		
		buttons[19] = new JButton("**");
		buttons[20] = new JButton("1/X");
		buttons[21] = new JButton("X!");
		buttons[22] = new JButton("Log");
		
		
		//result button - extra grid
		buttons[16] = new JButton("C");
		buttons[17] = new JButton("=");
		buttons[18] = new JButton("del");
		
		//grids
		auxOutput.setLayout(new GridLayout(1, 3, 2, 2));
		auxOutput.add(buttons[16]);
		auxOutput.add(buttons[17]);
		auxOutput.add(buttons[18]);
		
		auxControl.setLayout(new GridLayout(5, 4, 2, 2));
		//first row
		for(int i = 7;i < 10;i++){
			auxControl.add(buttons[i]);
		}
		auxControl.add(buttons[10]);
		//second row
		for(int i = 4;i < 7;i++){
			auxControl.add(buttons[i]);
		}
		auxControl.add(buttons[11]);
		//third row
		for(int i = 1;i < 4;i++){
			auxControl.add(buttons[i]);
		}
		auxControl.add(buttons[12]);
		//forth row
		auxControl.add(buttons[14]);
		auxControl.add(buttons[0]);
		auxControl.add(buttons[15]);
		auxControl.add(buttons[13]);
		//fifthrow
		auxControl.add(buttons[19]);
		auxControl.add(buttons[20]);
		auxControl.add(buttons[21]);
		auxControl.add(buttons[22]);
				
		//Buttons color Set
		for(int i = 0; i < buttons.length;i++){
			buttons[i].setFont(button);
			if(i < 10){
				buttons[i].setForeground(Color.BLUE);
			}else{
				buttons[i].setForeground(Color.RED);
			}
		}

		//Frame pane
		getContentPane().setLayout(new BorderLayout(2, 2));
		getContentPane().add(labelsJP, BorderLayout.NORTH);
		getContentPane().add(auxControl, BorderLayout.CENTER);
		getContentPane().add(auxOutput, BorderLayout.SOUTH);
		requestFocus();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		//Exit Listener
		addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				System.exit(0);
			}
		});
		
		
		//Icon
		ImageIcon img = new ImageIcon("C:/Users/JAT/Desktop/Git/MVCSwingCalculator/Calculator/src/icon.gif");
        Image logo = img.getImage();
        setIconImage(logo);
	}
	public void addCalculatorListener(ActionListener calculatorListener){
		for(int i = 0;i < buttons.length;i++){
			buttons[i].addActionListener(calculatorListener);
		}
	}	

	public String getFirstNumber() {
		return firstNumber.getText();
	}

	public void setFirstNumber(String firstNumber) {
		this.firstNumber.setText(firstNumber);
	}

	public String getSecondNumber() {
		return secondNumber.getText();
	}

	public void setSecondNumber(String secondNumber) {
		this.secondNumber.setText(secondNumber);
	}

	public String getAnswerLabel() {
		return answerLabel.getText();
	}

	public void setAnswerLabel(String answerLabel) {
		this.answerLabel.setText(answerLabel); 
	}

	public void setSymbolLabel(String symbolLabel) {
		this.symbolLabel.setText(symbolLabel);
	}

	
	public JButton getButtons(int i){
		return buttons[i];
	}
	
}
