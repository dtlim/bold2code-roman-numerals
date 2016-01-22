package calculator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static calculator.RomanNumeralCalculator.Operator.*;
import static junit.framework.Assert.assertEquals;

@RunWith(BlockJUnit4ClassRunner.class)
public class RomanNumeralCalculatorTest {

	private RomanNumeralCalculator calculator;

	@Before
	public void setup() {
		calculator = new MyRomanNumeralCalculator();
	}

	/**
	 * Low non-negative numbers
	 */
	@Test
	public void basic() {
		// Add
		assertEquals(calculator.compute("i", "ii", add), "iii");
		assertEquals(calculator.compute("iii", "i", add), "iv");
		assertEquals(calculator.compute("vi", "v", add), "xi");
		assertEquals(calculator.compute("v", "vi", add), "xi");
		assertEquals(calculator.compute("xii", "v", add), "xvii");
		assertEquals(calculator.compute("xxx", "xi", add), "xli"); // 30 + 11

		// Subtract
		assertEquals(calculator.compute("ii", "i", subtract), "i");
		assertEquals(calculator.compute("vi", "ii", subtract), "iv");

		// Multiply
		assertEquals(calculator.compute("i", "ii", multiply), "ii");
		assertEquals(calculator.compute("v", "x", multiply), "l");
		assertEquals(calculator.compute("v", "iii", multiply), "xv");
	}

	/**
	 * Includes negative numbers and numbers with a higher absolute value
	 */
	@Test
	public void intermediate() {
		// Add
		assertEquals(calculator.compute("-ii", "i", add), "-i");
		assertEquals(calculator.compute("i", "-ii", add), "-i");
		assertEquals(calculator.compute("x", "-xv", add), "-v");
		assertEquals(calculator.compute("-x", "xv", add), "v");

		// Multiply
		assertEquals(calculator.compute("i", "-i", multiply), "-i");
		assertEquals(calculator.compute("-i", "i", multiply), "-i");
		assertEquals(calculator.compute("m", "m", multiply), "M");

		// 24 and 9
		assertEquals(calculator.compute("xxiv", "ix", add), "xxxiii");
		assertEquals(calculator.compute("xxiv", "ix", subtract), "xv");
		assertEquals(calculator.compute("xxiv", "ix", multiply), "ccxvi");
	}

	@Test
	public void advancedAndEdgeCases() {
		assertEquals(calculator.compute("i", "ii", subtract), "-i");
		assertEquals(calculator.compute("v", "v", subtract), "");
		assertEquals(calculator.compute("xlv", "lxxxvii", multiply), "mmmcmxv"); // 45 x 87

		// 123 and 345
		assertEquals(calculator.compute("cxxiii", "cccxlv", add), "cdlxviii");
		assertEquals(calculator.compute("cxxiii", "cccxlv", subtract), "-ccxxii");
		assertEquals(calculator.compute("cxxiii", "cccxlv", multiply), "XLmmcdxxxv");

		// 830 and 749
		assertEquals(calculator.compute("dcccxxx", "dccxlix", add), "mdlxxix");
		assertEquals(calculator.compute("dcccxxx", "dccxlix", subtract), "lxxxi");
		assertEquals(calculator.compute("dcccxxx", "dccxlix", multiply), "DCXXmdclxx");

		// 998 and 999
		assertEquals(calculator.compute("cmxcviii", "cmxcix", add), "mcmxcvii");
		assertEquals(calculator.compute("cmxcviii", "cmxcix", subtract), "-i");
		assertEquals(calculator.compute("cmxcviii", "cmxcix", multiply), "CMXCVmmii");
	}


}

