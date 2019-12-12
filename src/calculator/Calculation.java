package calculator;


public class Calculation {
	  private String operator;
	  private Double firstNumber;
	  private Double secondNumber;
	  private Double answer;
	  private long id;

	  public Calculation(long id, Double first, String operator, Double second) {
	    this.operator = operator;
	    this.firstNumber = first;
	    this.secondNumber = second;
	    this.id = id;
	  }
	  
	  public Double getAnswer(){
		  if (operator.toLowerCase().equals("plus")){
			  answer = firstNumber + secondNumber;
		  }
		  else if (operator.toLowerCase().equals("minus")){
			  answer = firstNumber - secondNumber;
		  }
		  if (operator.toLowerCase().equals("times")){
			  answer = firstNumber * secondNumber;
		  }
		  if (operator.toLowerCase().equals("divided by")){
			  answer = firstNumber / secondNumber;
		  }
		  
		  return answer;
	  }
	  
	  public Double getFirstNumber(){
		  return firstNumber;
	  }
	  
	  public Double getSecondNumber(){
		  return secondNumber;
	  }
	  
	  public String getOperator(){
		  return operator;
	  }
	  
	  public long getId(){
		  return id;
	  }
}
