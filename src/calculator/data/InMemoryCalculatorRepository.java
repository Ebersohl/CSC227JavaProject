package calculator.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import calculator.Calculation;


@Component
public class InMemoryCalculatorRepository implements CalculatorRepository{
	private List<Calculation> calcs = new ArrayList<Calculation>();

	@Override
	public List<Calculation> findRecentCalculations() {
		return calcs;
	}

	@Override
	public List<Calculation> findCalculation(long max, int count) {
		List<Calculation> result = new ArrayList<Calculation>();
		int counter = 0;
		for (int i = 0; i < calcs.size(); i++) {
			Calculation calc = calcs.get(i);
			if (calc != null && calc.getId() <= max && counter < count) {
				result.add(calc);
				counter++;
			}
		}
		return result;
	}

	@Override
	public Calculation findOne(long id) {
		Calculation result = null;
		for (int i = 0; i < calcs.size(); i++) {
			Calculation calc = calcs.get(i);
			if (calc != null && calc.getId() == id) {
				result = calc;
				break;
			}
		}
		return result;
	}

	@Override
	public void save(Calculation calc) {
		calcs.add(calc);
	}

}
