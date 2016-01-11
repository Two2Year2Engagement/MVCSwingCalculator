package MVC.Calculator;

public class Model {
	private double firstNumber, secondNumber, answer;
	private String erro;
	
	public Model(){
		firstNumber = 0;
		secondNumber = 0;
		answer = 0;
		erro = "";
	}

	public String getFirstNumber() {
		return firstNumber + "";
	}

	public void setFirstNumber(String firstNumber) {
		this.firstNumber = Double.parseDouble(firstNumber);
	}

	public String getSecondNumber() {
		return secondNumber + "";
	}

	public void setSecondNumber(String secondNumber) {
		this.secondNumber = Double.parseDouble(secondNumber);
	}

	public String getAnswer() {
		if(erro.length() > 0){
			return erro;
		}else{
			String str = answer + "";
			return str;
		}
	}

	
	public void operator(String str){
		switch(str){
		case "+": add();
				break;
		case "-": minus();
				break;
		case "/": divided();
				break;
		case "*": multiply();
				break;
		}
	}
	
	public void add(){
		answer = firstNumber + secondNumber;
	}
	
	public void minus(){
		answer = firstNumber - secondNumber;
	}
	
	public void multiply(){
		answer = firstNumber * secondNumber;
	}
	
	public void divided(){
		if(secondNumber != 0){
			answer = firstNumber / secondNumber;
		}else{
			erro = "Cannot Divide by 0";
		}
	}
}
