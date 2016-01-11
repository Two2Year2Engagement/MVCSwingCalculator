package MVC.Calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
	private View view;
	private Model model;
	
	public Controller(View view, Model model){
		this.view = view;
		this.model = model;
		
		this.view.addCalculatorListener(new CalculatorListener());
	}
	
	class CalculatorListener implements ActionListener{
		private boolean inputFirst, inputSecond, getAnswer;
		private String operator;
		
		public CalculatorListener(){
			inputFirst = true;
			inputSecond = false;
			getAnswer = false;
			operator = "";
		}
		
		public void actionPerformed(ActionEvent e){
			//Numbers
			if(e.getSource() == view.getButtons(0)){
				addDigit(0);
			}
			if(e.getSource() == view.getButtons(1)){
				addDigit(1);
			}
			if(e.getSource() == view.getButtons(2)){
				addDigit(2);
			}
			if(e.getSource() == view.getButtons(3)){
				addDigit(3);
			}
			if(e.getSource() == view.getButtons(4)){
				addDigit(4);
			}
			if(e.getSource() == view.getButtons(5)){
				addDigit(5);
			}
			if(e.getSource() == view.getButtons(6)){
				addDigit(6);
			}
			if(e.getSource() == view.getButtons(7)){
				addDigit(7);
			}
			if(e.getSource() == view.getButtons(8)){
				addDigit(8);
			}
			if(e.getSource() == view.getButtons(9)){
				addDigit(9);
			}
			
			//operators
			if(e.getSource() == view.getButtons(10)){
				operator("+");
			}
			if(e.getSource() == view.getButtons(11)){
				operator("-");
			}
			if(e.getSource() == view.getButtons(12)){
				operator("*");
			}
			if(e.getSource() == view.getButtons(13)){
				operator("/");
			}
			
			//controls
			if(e.getSource() == view.getButtons(14)){
				signChange();
			}
			if(e.getSource() == view.getButtons(15)){
				floatPoint();
			}
			if(e.getSource() == view.getButtons(16)){
				clear();
			}
			if(e.getSource() == view.getButtons(17)){
				equals();
			}
			if(e.getSource() == view.getButtons(18)){
				minusDigit();
			}	
		}
		
		public void addDigit(int i){
			if(inputFirst){
				String str = view.getFirstNumber();
				if(str.indexOf("0") == 0){
					view.setFirstNumber(i+"");
				}else{
					view.setFirstNumber(str+i);
				}
			}else{
				String str = view.getSecondNumber();
				if(str.indexOf("0") == 0){
					view.setSecondNumber(i+"");
				}else{
					view.setSecondNumber(str+i);
				}
			}
		}
		
		public void operator(String str){
			inputFirst = false;
			inputSecond = true;
			operator = str;
			view.setSymbolLabel(str);
		}
		
		public void signChange(){
			if(inputFirst){
				String str = view.getFirstNumber();
				
				if (str.length() > 0 && !str.equals("0")) {
					if (str.indexOf("-") == 0)
						view.setFirstNumber(str.substring(1));
					else
						view.setFirstNumber("-" + str);
				}
			}else{
				String str = view.getSecondNumber();
				
				if (str.length() > 0 && !str.equals("0")) {
					if (str.indexOf("-") == 0)
						view.setSecondNumber(str.substring(1));
					else
						view.setSecondNumber("-" + str);
				}
			}
		}
		
		public void floatPoint(){
			if(inputFirst){
				String str = view.getFirstNumber();
				
				if(!(str.indexOf(".") > 0)){
					view.setFirstNumber(str+".");
				}
			}else{
				String str = view.getSecondNumber();
				
				if(!(str.indexOf(".") > 0)){
					view.setSecondNumber(str+".");
				}
			}
		}
		
		public void clear(){
			inputFirst = true;
			inputSecond = false;
			getAnswer = false;
			view.setFirstNumber("0");
			view.setSecondNumber("0");
			view.setAnswerLabel("0");
			view.setSymbolLabel(" ");
		}
		
		public void equals(){
			inputFirst = false;
			inputSecond = false;
			getAnswer = true;
			
			model.setFirstNumber(view.getFirstNumber());
			model.setSecondNumber(view.getSecondNumber());
			model.operator(operator);
			
			view.setAnswerLabel(model.getAnswer());
			
		}
		
		public void minusDigit(){
			if(inputFirst){
				String str = view.getFirstNumber();
				
				if(str.length() > 1 && !str.equalsIgnoreCase("0")){
					str = str.substring(0, (str.length() - 1));
					view.setFirstNumber(str);
				}else{
					view.setFirstNumber("0");
				}
			}else{
				String str = view.getSecondNumber();
				
				if(str.length() > 1 && !str.equalsIgnoreCase("0")){
					str = str.substring(0, (str.length() - 1));
					view.setSecondNumber(str);
				}else{
					view.setSecondNumber("0");
				}
			}
		}
		
		
	}


}
