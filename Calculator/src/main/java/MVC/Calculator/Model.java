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
		case "**": power();
				break;
		case "1/X": invert();
				break;
		case "X!": fatorial();
				break;
		case "Log": log();
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
	
	public void power(){
		answer = Math.pow(firstNumber, secondNumber);
	}
	
	public void invert(){
		answer = 1 / firstNumber;
	}
	
	public void fatorial(){
		int aux = (int) firstNumber;
		int fat = 1;
		
		if(aux < 2){
			answer = fat;
		}else{
			for(int i = 1;i <= aux;i++){
				fat = fat * i;
			}
			answer = fat;
		}
	}
	
	public void log(){
		answer = Math.log(firstNumber);
	}
}
