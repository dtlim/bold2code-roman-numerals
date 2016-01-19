package calculator;

/**
 * Created by dale on 1/19/16.
 */

public class MyRomanNumeralCalculator implements RomanNumeralCalculator {
    String[] thousandsString = {"m", "mm", "mmm", "V", "mV", "Vm", "Vmm", "Vmmm", "mX", "X"};
    String[] hundredsString = {"c", "cc", "ccc", "d", "cd", "dc", "dcc", "dccc", "cm"};
    String[] tensString = {"x", "xx", "xxx", "l", "xl", "lx", "lxx", "lxxx", "xc"};
    String[] onesString = {"i", "ii", "iii", "v", "iv", "vi", "vii", "viii", "ix"};
    int[] numbers = {1, 2, 3, 5, 4, 6, 7, 8, 9, 10};

    @Override
    public String compute(String romanNumeralOne, String romanNumeralTwo, Operator operation) {
        int a = romanNumeralToNumber(romanNumeralOne);
        int b = romanNumeralToNumber(romanNumeralTwo);
        int result = 0;

        if (operation.equals(Operator.add)) {
            result = a + b;
        }
        else if (operation.equals(Operator.subtract)) {
            result = a - b;
        }
        else if (operation.equals(Operator.multiply)) {
            result = a * b;
        }
        return numberToRomanNumeral(result);
    }

    public int romanNumeralToNumber(String romanNumeral) {
        int thousands = 0;
        int hundreds = 0;
        int tens = 0;
        int ones = 0;
        int sign = 1;

        if (romanNumeral.contains("-")) {
            sign = -1;
        }

        for (int a = 0; a < thousandsString.length; a++) {
            if (romanNumeral.contains(thousandsString[a])) {
                thousands = numbers[a];
            }
        }
        for (int a = 0; a < hundredsString.length; a++) {
            if (romanNumeral.contains(hundredsString[a])) {
                hundreds = numbers[a];
            }
        }
        for (int a = 0; a < tensString.length; a++) {
            if (romanNumeral.contains(tensString[a])) {
                tens = numbers[a];
            }
        }
        for (int a = 0; a < onesString.length; a++) {
            if (romanNumeral.contains(onesString[a])) {
                ones = numbers[a];
            }
        }

        return ((thousands * 1000) + (hundreds * 100) + (tens * 10) + ones) * sign;
    }

    public String numberToRomanNumeral(int number) {
        String sign = "";
        int thousands = 0;
        int hundreds = 0;
        int tens = 0;
        int ones = 0;

        if (number < 0) {
            sign = "-";
            number *= -1;
        }

        thousands = number / 1000;
        number %= 1000;
        hundreds = number / 100;
        number %= 100;
        tens = number / 10;
        number %= 10;
        ones = number;

        String thousandsRN = "";
        String hundredsRN = "";
        String tensRN = "";
        String onesRN = "";

        if (thousands != 0) {
            thousandsRN = thousandsString[getIndex(thousands)];
        }
        if (hundreds != 0) {
            hundredsRN = hundredsString[getIndex(hundreds)];
        }
        if (tens != 0) {
            tensRN = tensString[getIndex(tens)];
        }
        if (ones != 0) {
            onesRN = onesString[getIndex(ones)];
        }

        return (sign + thousandsRN + hundredsRN + tensRN + onesRN);
    }

    public int getIndex(int x) {
        for (int a = 0; a < numbers.length; a++) {
            if (x == numbers[a]) {
                return a;
            }
        }
        return -1;
    }
}