package calculator;


public interface RomanNumeralCalculator {
	/**
	 *
	 * @param romanNumeralOne Roman numeral string whose numeric value can range from 0 to 100
	 * @param romanNumeralTwo Roman numeral string whose numeric value can range from 0 to 100
	 * @param operation The arithmetic operation to perform. Values can be either "add", "subtract", or "multiply"
	 * @return
	 */
	public String compute(String romanNumeralOne, String romanNumeralTwo, String operation);
}
