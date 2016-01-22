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
		assertEquals("iii", calculator.compute("i", "ii", add));
		assertEquals("iv", calculator.compute("iii", "i", add));
		assertEquals("xi", calculator.compute("vi", "v", add));
		assertEquals("xi", calculator.compute("v", "vi", add));
		assertEquals("xvii", calculator.compute("xii", "v", add));
		assertEquals("xli", calculator.compute("xxx", "xi", add)); // 30 + 11

		// Subtract
		assertEquals("i", calculator.compute("ii", "i", subtract));
		assertEquals("iv", calculator.compute("vi", "ii", subtract));

		// Multiply
		assertEquals("ii", calculator.compute("i", "ii", multiply));
		assertEquals("l", calculator.compute("v", "x", multiply));
		assertEquals("xv", calculator.compute("v", "iii", multiply));
	}

	/**
	 * Includes negative numbers and numbers with a higher absolute value
	 */
	@Test
	public void intermediate() {
		// Add
		assertEquals("-i", calculator.compute("-ii", "i", add));
		assertEquals("-i", calculator.compute("i", "-ii", add));
		assertEquals("-v", calculator.compute("x", "-xv", add));
		assertEquals("v", calculator.compute("-x", "xv", add));

		// Multiply
		assertEquals("-i", calculator.compute("i", "-i", multiply));
		assertEquals("-i", calculator.compute("-i", "i", multiply));
		assertEquals("M", calculator.compute("m", "m", multiply));

		// 24 and 9
		assertEquals("xxxiii", calculator.compute("xxiv", "ix", add));
		assertEquals("xv", calculator.compute("xxiv", "ix", subtract));
		assertEquals("ccxvi", calculator.compute("xxiv", "ix", multiply));
	}

	@Test
	public void advancedAndEdgeCases() {
		assertEquals("-i", calculator.compute("i", "ii", subtract));
		assertEquals("", calculator.compute("v", "v", subtract));
		assertEquals("mmmcmxv", calculator.compute("xlv", "lxxxvii", multiply)); // 45 x , 87

		// 123 and 345
		assertEquals("cdlxviii", calculator.compute("cxxiii", "cccxlv", add));
		assertEquals("-ccxxii", calculator.compute("cxxiii", "cccxlv", subtract));
		assertEquals("XLmmcdxxxv", calculator.compute("cxxiii", "cccxlv", multiply));

		// 830 and 749
		assertEquals("mdlxxix", calculator.compute("dcccxxx", "dccxlix", add));
		assertEquals("lxxxi", calculator.compute("dcccxxx", "dccxlix", subtract));
		assertEquals("DCXXmdclxx", calculator.compute("dcccxxx", "dccxlix", multiply));

		// 998 and 999
		assertEquals("mcmxcvii", calculator.compute("cmxcviii", "cmxcix", add));
		assertEquals("-i", calculator.compute("cmxcviii", "cmxcix", subtract));
		assertEquals("CMXCVmmii", calculator.compute("cmxcviii", "cmxcix", multiply));
	}

}
