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
		calculator = new MiggyCalculator();
	}

	@Test
	public void multiply1and2() {
		String result = calculator.compute("I", "II", "multiply");
		assertEquals(result, "II");
	}

	@Test
	public void add4and2() {
		String result = calculator.compute("IV", "II", "add");
		assertEquals(result, "VI");
	}
}
