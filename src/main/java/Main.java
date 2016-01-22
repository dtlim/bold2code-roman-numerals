import calculator.MyRomanNumeralCalculator;
import calculator.RomanNumeralCalculator;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		RomanNumeralCalculator calc = new MyRomanNumeralCalculator();
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter roman numeral one: ");
			String romanOne = sc.nextLine();
			System.out.print("Enter roman numeral two: ");
			String romanTwo = sc.nextLine();
			System.out.print("Enter the operation: ");
			String operator = sc.nextLine();

			System.out.println("The answer is: " + calc.compute(romanOne, romanTwo, RomanNumeralCalculator.Operator.valueOf(operator)));
		}
	}
}
