package calculator.web;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CalcForm {

	@NotNull
	@Size(min = 1, max = 10)
	private String operator;

	private Double firstNumber = new Double(0.0);

	private Double secondNumber = new Double(0.0);

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Double getFirstNumber() {
		return firstNumber;
	}

	public void setFirstNumber(Double firstNumber) {
		if (firstNumber == null)
			this.firstNumber = new Double(0.0);
		else
			this.firstNumber = firstNumber;
	}

	public Double getSecondNumber() {
		return secondNumber;
	}

	public void setSecondNumber(Double secondNumber) {
		if (secondNumber == null)
			this.secondNumber = new Double(0.0);
		else
			this.secondNumber = secondNumber;

	}
	
	public Double getAnswer() {
		  if (operator.toLowerCase().equals("plus")){
			  return firstNumber + secondNumber;
		  }
		  else if (operator.toLowerCase().equals("minus")){
			  return firstNumber - secondNumber;
		  }
		  else if (operator.toLowerCase().equals("times")){
			  return firstNumber * secondNumber;
		  }
		  else if (operator.toLowerCase().equals("divided by")){
			  return firstNumber / secondNumber;
		  }
		  else{
			  return 0.0;
		  }

	  }
}
