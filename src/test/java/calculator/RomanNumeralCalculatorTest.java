package calculator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static junit.framework.Assert.assertEquals;

@RunWith(BlockJUnit4ClassRunner.class)
public class RomanNumeralCalculatorTest {

	private RomanNumeralCalculator calculator;

	@Before
	public void setup() {
		calculator = new MyRomanNumeralCalculator();
	}

	@Test
	public void testAddition() {
		String result = calculator.compute("i", "ii", RomanNumeralCalculator.Operator.add);
		assertEquals("iii", result);

		result = calculator.compute("iii", "i", RomanNumeralCalculator.Operator.add);
		assertEquals("iv", result);

		result = calculator.compute("vi", "v", RomanNumeralCalculator.Operator.add);
		assertEquals("xi", result);

		result = calculator.compute("v", "vi", RomanNumeralCalculator.Operator.add);
		assertEquals("xi", result);

        result = calculator.compute("-ii", "i", RomanNumeralCalculator.Operator.add);
        assertEquals("-i", result);

        result = calculator.compute("i", "-ii", RomanNumeralCalculator.Operator.add);
        assertEquals("-i", result);

        result = calculator.compute("x", "-xv", RomanNumeralCalculator.Operator.add);
        assertEquals("-v", result);

        result = calculator.compute("-x", "xv", RomanNumeralCalculator.Operator.add);
        assertEquals("v", result);

	}

	@Test
	public void testSubtraction() {
		String result = calculator.compute("ii", "i", RomanNumeralCalculator.Operator.subtract);
		assertEquals("i", result);

        result = calculator.compute("i", "ii", RomanNumeralCalculator.Operator.subtract);
		assertEquals("-i", result);

        result = calculator.compute("vi", "ii", RomanNumeralCalculator.Operator.subtract);
        assertEquals("iv", result);

        result = calculator.compute("v", "v", RomanNumeralCalculator.Operator.subtract);
        assertEquals("", result);
	}

    @Test
	public void testMultiplication() {
		String result = calculator.compute("i", "ii", RomanNumeralCalculator.Operator.multiply);
		assertEquals("ii", result);

        result = calculator.compute("i", "-i", RomanNumeralCalculator.Operator.multiply);
        assertEquals("-i", result);

        result = calculator.compute("-i", "i", RomanNumeralCalculator.Operator.multiply);
        assertEquals("-i", result);

        result = calculator.compute("v", "x", RomanNumeralCalculator.Operator.multiply);
        assertEquals("l", result);

        result = calculator.compute("v", "iii", RomanNumeralCalculator.Operator.multiply);
        assertEquals("xv", result);

        result = calculator.compute("m", "m", RomanNumeralCalculator.Operator.multiply);
        assertEquals("M", result);

        // 45 x 87
        result = calculator.compute("xlv", "lxxxvii", RomanNumeralCalculator.Operator.multiply);
        assertEquals("mmmcmxv", result);

        // 123 x 345
        result = calculator.compute("cxxiii", "cccxlv", RomanNumeralCalculator.Operator.multiply);
        assertEquals("XLmmcdxxxv", result);
	}

}

