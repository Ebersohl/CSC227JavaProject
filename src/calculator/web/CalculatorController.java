package calculator.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import calculator.Calculation;
import calculator.data.CalculatorRepository;


@Controller
@RequestMapping({"/calc"})
public class CalculatorController {

  private static final String MAX_LONG_AS_STRING = "9223372036854775807";
  private static long calculationCount = 0L; 
  
  private CalculatorRepository calculatorRepository;

  @Autowired
  public CalculatorController(CalculatorRepository calculatorRepository) {
    this.calculatorRepository = calculatorRepository;
  }

  @RequestMapping(method=RequestMethod.GET)
  public List<Calculation> calcs(
      @RequestParam(value="max", defaultValue=MAX_LONG_AS_STRING) long max,
      @RequestParam(value="count", defaultValue="20") int count) {
    return calculatorRepository.findCalculation(max, count);
  }

  @RequestMapping(value="/{calculatorId}", method=RequestMethod.GET)
  public String calcs(
      @PathVariable("calculatorId") long calculatorId, 
      Model model) {
    model.addAttribute(calculatorRepository.findOne(calculatorId));
    return "calculator";
  }

  @RequestMapping(method=RequestMethod.POST)
  public String saveCalculator(CalcForm form, Model model) throws Exception {
	  calculatorRepository.save(new Calculation(++calculationCount, form.getFirstNumber(), form.getOperator(), 
        form.getSecondNumber()));
    return "redirect:/calc";
  }

}
