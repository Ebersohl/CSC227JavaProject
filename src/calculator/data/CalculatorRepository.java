package calculator.data;

import java.util.List;

import calculator.Calculation;


public interface CalculatorRepository {

  /**
   * @return the most recent 20 spittles
   */
  List<Calculation> findRecentCalculations();

  /**
   * @param max maximum spittle id
   * @param count number of spittles to return
   * @return the number of count of spittles that have ids lower then max
   */
  List<Calculation> findCalculation(long max, int count);
  /**
   * @param id spittle's id
   * @return the one spittle whose id is id
   */
  Calculation findOne(long id);
  /**
   * @param spittle the spittle to be saved
   */
  void save(Calculation calc);

}
