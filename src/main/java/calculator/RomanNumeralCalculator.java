package calculator;


public interface RomanNumeralCalculator {

	public enum Operator {
		add, subtract, multiply
	}
	
	/**
	 *
	 * @param romanNumeralOne Roman numeral string whose numeric value can range from -1,000 to 1,000
	 * @param romanNumeralTwo Roman numeral string whose numeric value can range from -1,000 to 1,000
	 * @param operation The arithmetic operation to perform. Values can be either "add", "subtract", or "multiply"
	 * @return the answer after applying the operator to the two roman numerals, with the first one being on the left hand side
	 */
	public String compute(String romanNumeralOne, String romanNumeralTwo, Operator operation);
}
